package com.oiji.springweb.service.image;

import com.oiji.springweb.dto.image.Image;
import com.oiji.springweb.entity.ImageEntity;
import com.oiji.springweb.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;
    private int start = 0;

    public Image getImageById(String id) {
        Image image = imageMapper.getImageById(id).toDto();
        return image;
    }

    public List<Image> getHomeImageList() {
        setPage(1);
        List<Image> list = imageMapper.getImageList("", start)
                            .stream().map(ImageEntity::toDto).collect(Collectors.toList());
        return list;
    }

    public List<Image> getImageList(String query, int page) {
        setPage(page);
        List<Image> list = imageMapper.getImageList(query, start)
                .stream().map(ImageEntity::toDto).collect(Collectors.toList());
        return list;
    }

    public List<Image> getImageListByTheme(String theme, int page) {
        setPage(page);
        List<Image> list = imageMapper.getImageListByTheme(theme, start)
                .stream().map(ImageEntity::toDto).collect(Collectors.toList());
        return list;
    }

    public List<Image> getImageListByContext(String context, int page) {
        setPage(page);
        List<Image> list = imageMapper.getImageListByContext(context, start)
                .stream().map(ImageEntity::toDto).collect(Collectors.toList());
        return list;
    }

    public void addImage(String title, String imgPath, String theme, String context){
        imageMapper.insertImage(title, imgPath, theme, context);
    }

    public void updateImageHit(String id) {
        imageMapper.updateImageHit(id);
    }

    private void setPage(int page) {
        start = (page - 1) * 32;
    }

}
