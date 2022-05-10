package com.oiji.springweb.entity;

import lombok.Data;

@Data
public class ImageEntity {

    private int id;
    private String[] title;
    private String imgPath;
    private int hit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.split(" ");
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public ImageEntity(int id, String title, String imgPath, int hit) {
        this.id = id;
        this.title = title.split(" ");
        this.imgPath = imgPath;
        this.hit = hit;
    }
}
