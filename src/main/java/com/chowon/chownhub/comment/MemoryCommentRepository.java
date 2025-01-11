package com.chowon.chownhub.comment;

import java.util.HashMap;
import java.util.Map;

public class MemoryCommentRepository implements CommentRepository {
    private static final Map<Long, Comment> comments = new HashMap<>();

    @Override
    public void create(Comment comment) {
        comments.put(comment.getCommentId(), comment);
    }

    @Override
    public void update(Comment comment) {
        comments.put(comment.getCommentId(), comment);
    }

    @Override
    public void delete(long commentId) {
        comments.put(commentId, null);
    }
}
