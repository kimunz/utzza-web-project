package com.oiji.springweb.dto.article;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reply {

    private int id;
    private String content;
    private Timestamp regDate;
    private String writerId;
    private int boardId;
}
