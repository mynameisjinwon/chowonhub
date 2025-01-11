package com.chowon.chownhub.comment;

public interface CommentRepository {
    void create(Comment comment);

    void update(Comment comment);

    void delete(long commentId);
}
