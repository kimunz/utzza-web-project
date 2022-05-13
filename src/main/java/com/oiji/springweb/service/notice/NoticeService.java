package com.oiji.springweb.service.notice;

import com.oiji.springweb.entity.NoticeEntity;
import com.oiji.springweb.mapper.NoticeMapper;
import com.oiji.springweb.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public List<NoticeEntity> findAll(Criteria criteria) {
        return noticeMapper.getNoticeList(criteria);
    }

    public int getNoticeCount(Criteria criteria) {
        return noticeMapper.getNoticeCount(criteria);
    }

    public NoticeEntity findById(int id) {
        return noticeMapper.getNoticeById(id);
    }
}
