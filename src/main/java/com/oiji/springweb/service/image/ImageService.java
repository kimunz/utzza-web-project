package com.oiji.springweb.service.image;

import com.oiji.springweb.dao.ImageDao;
import com.oiji.springweb.dto.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageDao imageDao;

    public List<Image> getHomeImageList() {
        List<Image> list = imageDao.getImageList("", 1);
        return list;
    }

}
