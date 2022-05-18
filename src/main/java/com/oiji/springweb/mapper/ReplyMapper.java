package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

    List<Reply> getReply(int boardId);


}
