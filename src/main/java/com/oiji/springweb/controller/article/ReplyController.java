package com.oiji.springweb.controller.article;

import com.oiji.springweb.dto.article.Reply;
import com.oiji.springweb.service.article.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/list")
    public String getReply(@RequestParam int boardId) {
        List<Reply> replies = replyService.getReply(boardId);
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

    @PostMapping("/insert")
    public String addReply(@RequestBody Reply reply) {
        replyService.addReply(reply);
        return "success";
    }

    @PostMapping("/update")
    public String editReply(@RequestBody Reply reply) {
        replyService.editReply(reply);
        return "success";
    }

    @PostMapping("/delete")
    public String removeReply(@RequestParam int id) {
        replyService.removeReply(id);
        return "success";
    }
}
