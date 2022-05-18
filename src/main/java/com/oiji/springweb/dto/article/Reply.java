package com.oiji.springweb.dto.article;

import lombok.Data;

import java.sql.Date;

@Data
public class Reply {

    private int id;
    private String content;
    private Date regDate;
    private String writerId;
    private int boardId;
}
