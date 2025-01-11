package com.chowon.chownhub.comment;

import java.util.List;

public interface CommentRepository {
    void create(Comment comment);

    void update(Comment comment);

    void delete(long commentId);

    List<Comment> findByBoardId(long boardId);

    List<Comment> findAll();
}
