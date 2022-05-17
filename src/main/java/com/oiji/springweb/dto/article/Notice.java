package com.oiji.springweb.dto.article;

import lombok.Data;

import java.sql.Date;

@Data
public class Notice {
    private int id;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    private int hit;
    private String files;
    private int prevNid;
    private int nextNid;

}
