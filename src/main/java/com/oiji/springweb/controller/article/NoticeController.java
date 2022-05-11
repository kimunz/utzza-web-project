package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.paging.Criteria;
import com.oiji.springweb.paging.PaginationInfo;
import com.oiji.springweb.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String getNoticeListPage(@ModelAttribute Criteria criteria, Model model) {

        log.info("criteria={}", criteria.getPage());
        List<Notice> list = noticeService.findAll(criteria);
        int count = noticeService.getNoticeCount(criteria);

        for (Notice notice : list) {
            log.info("notice={}", notice.getTitle());
        }

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", new PaginationInfo(criteria, count, 5));

        return "notice/list";
    }

    @GetMapping("/notice/view")
    public String getNoticeViewPage() {

        return "";
    }
}
