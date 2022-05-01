package com.oiji.springweb.service.image;

import com.oiji.springweb.dao.ImageDao;
import com.oiji.springweb.dto.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ImageDao imageDao;

    public List<Image> searchImageList(String q) {
        return imageDao.getImageList(q, 1);
    }
}
