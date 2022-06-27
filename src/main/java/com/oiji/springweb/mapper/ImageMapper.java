package com.oiji.springweb.mapper;

import com.oiji.springweb.entity.ImageEntity;
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

    @Select("SELECT ID, TITLE, IMGPATH, HIT FROM (SELECT ROWNUM NUM, N.* FROM " +
            "(SELECT * FROM IMAGE WHERE THEME = #{theme} ORDER BY HIT DESC)N) " +
            "WHERE NUM BETWEEN #{start} AND #{end}")
    List<ImageEntity> getImageListByTheme(@Param("theme") String theme, @Param("start") int start, @Param("end") int end);

    @Select("SELECT ID, TITLE, IMGPATH, HIT FROM (SELECT ROWNUM NUM, N.* FROM " +
            "(SELECT * FROM IMAGE WHERE CONTEXT = #{context} ORDER BY HIT DESC)N) " +
            "WHERE NUM BETWEEN #{start} AND #{end}")
    List<ImageEntity> getImageListByContext(@Param("context") String context, @Param("start") int start, @Param("end") int end);

    @Select("SELECT ID, TITLE, IMGPATH, HIT FROM IMAGE WHERE ID = #{id}")
    ImageEntity getImageById(String id);

    void insertImage(@Param("title") String title, @Param("imgPath") String imgPath, @Param("theme") String theme, @Param("context") String context);

    void updateImageHit(String id);
}
