package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Reply;
import com.oiji.springweb.service.article.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService service;

    @GetMapping("/list")
    public String getReply(@RequestParam int boardId) {
        List<Reply> replies = service.getReply(boardId);
        DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        JSONArray jsonArray = new JSONArray();

        for (Reply reply : replies) {
            JSONObject json = new JSONObject();
            json.put("id", reply.getId());
            json.put("writerId", reply.getWriterId());
            json.put("content", reply.getContent());
            json.put("regDate", fm.format(reply.getRegDate()));
            jsonArray.put(json);
        }

        return jsonArray.toString();
    }

    @GetMapping("/insert")
    public String addReply() {

        return "";
    }

    @GetMapping("/update")
    public String editReply() {

        return "";
    }

    @GetMapping("/delete")
    public String removeReply() {

        return "";
    }
}
