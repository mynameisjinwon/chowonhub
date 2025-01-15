package com.chowon.chownhub.board;

public class Board {
    private long boardId;
    private String date;
    private BoardSubject subject;
    private String memberId;
    private String title;
    private String content;
    private long like;

    public Board(long boardId, String date, BoardSubject subject, String memberId, String title, String content, long like) {
        this.boardId = boardId;
        this.date = date;
        this.subject = subject;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.like = like;
    }

    public BoardSubject getSubject() {
        return subject;
    }

    public void setSubject(BoardSubject subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", date='" + date + '\'' +
                ", subject='" + subject + '\'' +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
