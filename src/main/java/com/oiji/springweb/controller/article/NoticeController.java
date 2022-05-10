package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.paging.Criteria;
import com.oiji.springweb.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public String getNoticeListPage(@ModelAttribute Criteria criteria, Model model) {

        List<Notice> list = noticeService.findAll(criteria);
        int count = noticeService.getNoticeCount(criteria);

        model.addAttribute("list", list);
        model.addAttribute("count", count);

        return "notice/list";
    }

    @GetMapping("/view")
    public String getNoticeViewPage() {

        return "";
    }
}
