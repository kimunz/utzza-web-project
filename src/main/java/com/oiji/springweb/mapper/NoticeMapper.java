package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.article.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("")
    List<Notice> getNoticeList();

    @Select("")
    int getNoticeCount();

}
