package com.oiji.springweb.dto.article;

import lombok.Data;

import java.sql.Date;

@Data
public class Board {
    private int id;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    private int hit;
    private String files;
    private int prevBId;
    private int nextBId;
    private int replyCount;

    public Board(int id, String title, String writerId, String content, Date regDate, int hit, String files, int replyCount, int prevBId, int nextBId) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.regDate = regDate;
        this.hit = hit;
        this.files = files;
        this.content = content;
        this.replyCount = replyCount;
        this.prevBId = prevBId;
        this.nextBId = nextBId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getPrevBId() {
        return prevBId;
    }

    public void setPrevBId(int prevBId) {
        this.prevBId = prevBId;
    }

    public int getNextBId() {
        return nextBId;
    }

    public void setNextBId(int nextBId) {
        this.nextBId = nextBId;
    }
}
