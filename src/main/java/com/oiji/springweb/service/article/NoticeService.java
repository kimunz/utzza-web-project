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

    public int addNotice(Notice notice) {
        notice.setContent(notice.getContent().replace("\r\n", "<br>"));
        return noticeMapper.addNotice(notice);
    }

    public int editNotice(Notice notice) {
        notice.setContent(notice.getContent().replace("\r\n", "<br>"));
        return noticeMapper.editNotice(notice);
    }

    public int removeNotice(int id) {
        return noticeMapper.removeNotice(id);
    }

    public Notice getNoticeById(Criteria criteria, int id) {
        return noticeMapper.getNoticeById(criteria, id);
    }

    public void updateNoticeHit(int id) {
        noticeMapper.updateNoticeHit(id);
    }


}
