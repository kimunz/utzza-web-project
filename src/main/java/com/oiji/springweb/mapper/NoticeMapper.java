package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice> getNoticeList(Criteria criteria);

    int getNoticeCount(Criteria criteria);

    Notice getNoticeById(@Param("criteria") Criteria criteria, @Param("id") int id);
}
