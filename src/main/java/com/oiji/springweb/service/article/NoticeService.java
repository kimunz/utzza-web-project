package com.oiji.springweb.service.article;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.mapper.NoticeMapper;
import com.oiji.springweb.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public List<Notice> findAll(Criteria criteria) {
        return noticeMapper.getNoticeList(criteria);
    }

    public int getNoticeCount(Criteria criteria) {
        return noticeMapper.getNoticeCount(criteria);
    }

    public Notice findById(int id) {
        return noticeMapper.getNoticeById(id);
    }
}
