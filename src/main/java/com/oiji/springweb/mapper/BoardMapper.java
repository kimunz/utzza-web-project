package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Board;
import com.oiji.springweb.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoardList(Criteria criteria);

    int getBoardCount(Criteria criteria);

    Board getBoardById(@Param("criteria") Criteria criteria, @Param("id") int id);

    int addBoard(Board board);
}
