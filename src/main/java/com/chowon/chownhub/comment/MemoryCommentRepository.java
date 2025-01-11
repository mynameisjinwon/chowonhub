package com.chowon.chownhub.comment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
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

    @Override
    public List<Comment> findByBoardId(long boardId) {
        List<Comment> all = findAll();
        List<Comment> tmp = new ArrayList<>();
        for (Comment c : all) {
            if (c.getBoardId() == boardId) {
                tmp.add(c);
            }
        }
        return tmp;
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(comments.values());
    }
}
