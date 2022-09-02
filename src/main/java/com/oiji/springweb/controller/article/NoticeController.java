package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.entity.UserEntity;
import com.oiji.springweb.paging.Criteria;
import com.oiji.springweb.paging.PaginationInfo;
import com.oiji.springweb.service.article.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String getNoticeListPage(@ModelAttribute Criteria criteria, Model model) {

        criteria.setRowNum((criteria.getPage() - 1) * 10);
        List<Notice> list = noticeService.findAll(criteria);
        int count = noticeService.getNoticeCount(criteria);

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", new PaginationInfo(criteria, count, 5));

        return "notice/list";
    }

    @GetMapping("/notice/view")
    public String getNoticeViewPage(@RequestParam int id,
                                    @ModelAttribute Criteria criteria,
                                    HttpServletRequest request,
                                    HttpServletResponse response,
                                    @AuthenticationPrincipal UserEntity user,
                                    Model model) {

        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();
        /*이전에 생성한 쿠키가 있는지 확인*/
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("notice"+id)) {
                    oldCookie = cookie;
                }
            }
        }
        /*이전에 본 기록이 없을 때*/
        if(oldCookie == null) {
            Cookie newCookie = new Cookie("notice"+id, "[" + id + "]");
            response.addCookie(newCookie);
            noticeService.updateNoticeHit(id);
        }

        Notice notice = noticeService.getNoticeById(criteria, id);
        model.addAttribute("notice", notice);
        model.addAttribute("user", user);

        return "notice/view";
    }

    @GetMapping("/notice/write")
    public String writeNoticeForm(@AuthenticationPrincipal UserEntity user, Model model) {

        model.addAttribute("user", user);
        return "notice/write";
    }

    @PostMapping("/notice/write")
    public String writeNotice(@ModelAttribute Notice notice) {

        noticeService.addNotice(notice);
        return "redirect:/notice";
    }

    @GetMapping("/notice/edit")
    public String editBoardForm(@RequestParam int id,
                                @ModelAttribute Criteria criteria,
                                @AuthenticationPrincipal UserEntity user,
                                Model model) {

        Notice notice = noticeService.getNoticeById(criteria, id);
        if (user == null || !user.getName().equals(notice.getWriterId())) {
            return "message/auth";
        }
        notice.setContent(notice.getContent().replace("<br>", "\r\n"));
        model.addAttribute("notice", notice);
        return "notice/edit";
    }

    @PostMapping("/notice/edit")
    public String editNotice(@ModelAttribute Notice notice) {
        noticeService.editNotice(notice);
        return "redirect:/notice";
    }

    @PostMapping("/notice/remove")
    public String removeNotice(@RequestParam int id,
                              @RequestParam String writerId,
                              @AuthenticationPrincipal UserEntity user) {

        if (user == null || !user.getName().equals(writerId)) {
            return "message/auth";
        }
        noticeService.removeNotice(id);
        return "redirect:/notice";
    }
}
