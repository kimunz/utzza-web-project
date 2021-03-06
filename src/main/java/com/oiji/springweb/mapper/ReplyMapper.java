package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    List<Reply> getReply(int boardId);

    int addReply(Reply reply);

    int editReply(Reply reply);

    int removeReply(int id);
}
