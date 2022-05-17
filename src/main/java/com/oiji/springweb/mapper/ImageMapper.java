package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.entity.ImageEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("SELECT ID, TITLE, IMGPATH, HIT FROM (SELECT ROWNUM NUM, N.* FROM " +
            "(SELECT * FROM IMAGE WHERE TITLE LIKE '%'|| #{query} ||'%' ORDER BY HIT DESC)N) " +
            "WHERE NUM BETWEEN #{start} AND #{end}")
    List<ImageEntity> getImageList(@Param("query") String query, @Param("start") int start, @Param("end") int end);

    @Select("SELECT * FROM IMAGE WHERE ID = #{id}")
    ImageEntity getImageById(String id);

    void insertImage(@Param("title") String title, @Param("imgPath") String imgPath);
}
