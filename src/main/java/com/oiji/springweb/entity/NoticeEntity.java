package com.oiji.springweb.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class NoticeEntity {
    private int id;
    private String title;
    private String writerId;
    private String content;
    private Date regdate;
    private int hit;
    private String files;

    public NoticeEntity(int id, String title, String writerId, String content, Date regdate, int hit, String files) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.content = content;
        this.regdate = regdate;
        this.hit = hit;
        this.files = files;
    }
}
