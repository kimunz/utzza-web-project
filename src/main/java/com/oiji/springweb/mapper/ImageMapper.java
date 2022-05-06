package com.oiji.springweb.mapper;

import com.oiji.springweb.dto.image.Image;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImageMapper {

    @Select("SELECT * FROM (SELECT ROWNUM NUM, N.* FROM " +
            "(SELECT * FROM IMAGE WHERE TITLE LIKE ? ORDER BY HIT DESC)N) " +
            "WHERE NUM BETWEEN ? AND ?")
    List<Image> getImageList(String query, int page);
}
