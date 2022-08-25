package com.oiji.springweb.dto.article;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notice {
    private int id;
    private String title;
    private String writerId;
    private String content;
    private Timestamp regDate;
    private int hit;
    private String files;
    private int prevNid;
    private int nextNid;

}
