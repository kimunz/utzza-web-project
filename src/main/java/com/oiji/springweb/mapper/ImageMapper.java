package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.image.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("SELECT * FROM (SELECT ROWNUM NUM, N.* FROM " +
            "(SELECT * FROM IMAGE WHERE TITLE LIKE '%'||#{query}||'%' ORDER BY HIT DESC)N) " +
            "WHERE NUM BETWEEN #{start} AND #{end}")
    List<Image> getImageList(@Param("query") String query, @Param("start") int start, @Param("end") int end);

    @Select("SELECT * FROM IMAGE WHERE ID = #{id}")
    Image getImageById(String id);
}
