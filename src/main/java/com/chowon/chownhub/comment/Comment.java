package com.chowon.chownhub.comment;

public class Comment {
    private long commentId;
    private long boardId;
    private String memberId;
    private String date;
    private String content;

    public Comment(long commentId, long boardId, String memberId, String date, String content) {
        this.commentId = commentId;
        this.boardId = boardId;
        this.memberId = memberId;
        this.date = date;
        this.content = content;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", boardId=" + boardId +
                ", memberId='" + memberId + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
