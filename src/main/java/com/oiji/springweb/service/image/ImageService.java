package com.oiji.springweb.service.image;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.entity.ImageEntity;
import com.oiji.springweb.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;
    private int start = 0;
    private int end = 0;

    public ImageEntity getImageById(String id) {
        ImageEntity image = imageMapper.getImageById(id);
        return image;
    }

    public List<ImageEntity> getHomeImageList(String query, int page) {
        setPage(page);
        List<ImageEntity> list = imageMapper.getImageList("", start, end);
        return list;
    }

    public List<ImageEntity> getImageList(String query, int page) {
        setPage(page);
        List<ImageEntity> list = imageMapper.getImageList(query, start, end);
        return list;
    }

    private void setPage(int page) {
        start = 1 + (page - 1) * 32;
        end = page * 32;
    }
}
