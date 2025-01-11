package com.chowon.chownhub.board;

public class Board {
    private long boardId;
    private String date;
    private String memberId;
    private String title;
    private String content;
    private String like;

    public Board(long boardId, String date, String memberId, String title, String content, String like) {
        this.boardId = boardId;
        this.date = date;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Board(long boardId, String memberId, String title, String content, String like) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.like = like;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
