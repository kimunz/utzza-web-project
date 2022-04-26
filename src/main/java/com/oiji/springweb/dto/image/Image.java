package com.oiji.springweb.dto.image;

import lombok.Data;

@Data
public class Image {

    private int id;
    private String[] title;
    private String imgPath;
    private int hit;

    public Image(int id, String[] title, String imgPath, int hit) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.hit = hit;
    }
}
