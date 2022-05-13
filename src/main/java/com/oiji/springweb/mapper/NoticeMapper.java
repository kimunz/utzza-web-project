package com.oiji.springweb.mapper;

import com.oiji.springweb.entity.NoticeEntity;
import com.oiji.springweb.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeEntity> getNoticeList(Criteria criteria);

    int getNoticeCount(Criteria criteria);

    NoticeEntity getNoticeById(int id);
}
