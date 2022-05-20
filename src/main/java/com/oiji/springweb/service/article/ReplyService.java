package com.oiji.springweb.service.article;

import com.oiji.springweb.dto.article.Reply;
import com.oiji.springweb.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    public List<Reply> getReply(int boardId) {
        return replyMapper.getReply(boardId);
    }

    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    public int editReply(Reply reply) {
        return replyMapper.editReply(reply);
    }

    public int removeReply(int id) {
        return replyMapper.removeReply(id);
    }
}
