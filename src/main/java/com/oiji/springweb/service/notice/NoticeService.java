package com.oiji.springweb.service.notice;

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
        List<Notice> list = noticeMapper.getNoticeList();
        return list;
    }

    public int getNoticeCount(Criteria criteria) {
        int count = noticeMapper.getNoticeCount();
        return count;
    }
}
