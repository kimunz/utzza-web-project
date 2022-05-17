package com.oiji.springweb.service.article;

import com.oiji.springweb.dto.article.Board;
import com.oiji.springweb.mapper.BoardMapper;
import com.oiji.springweb.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<Board> getBoardList(Criteria criteria) {
        return boardMapper.getBoardList(criteria);
    }

    public Board getBoardById(int id) {
        return boardMapper.getBoardById(id);
    }

    public int getBoardCount(Criteria criteria) {
        return boardMapper.getBoardCount(criteria);
    }
}
