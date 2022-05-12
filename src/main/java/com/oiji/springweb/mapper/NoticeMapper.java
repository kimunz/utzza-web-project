package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Notice;
import com.oiji.springweb.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice> getNoticeList(Criteria criteria);

    @Select("SELECT COUNT(ID) COUNT FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICE WHERE " +
            "#{c.field} LIKE '%'|| #{c.query} ||'%' ORDER BY REGDATE DESC)N)")
    int getNoticeCount(@Param("c") Criteria criteria);

}
