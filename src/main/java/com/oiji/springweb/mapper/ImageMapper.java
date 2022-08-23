package com.oiji.springweb.mapper;

import com.oiji.springweb.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageMapper {

    List<ImageEntity> getImageList(@Param("query") String query, @Param("start") int start);

    List<ImageEntity> getImageListByTheme(@Param("theme") String theme, @Param("start") int start);

    List<ImageEntity> getImageListByContext(@Param("context") String context, @Param("start") int start);

    ImageEntity getImageById(String id);

    void insertImage(@Param("title") String title, @Param("imgPath") String imgPath, @Param("theme") String theme, @Param("context") String context);

    void updateImageHit(String id);
}
