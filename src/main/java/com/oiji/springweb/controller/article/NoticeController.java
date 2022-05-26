package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.paging.Criteria;
import com.oiji.springweb.paging.PaginationInfo;
import com.oiji.springweb.service.article.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        Notice notice = noticeService.findById(criteria, id);
        model.addAttribute("notice", notice);

        return "notice/view";
    }
}
