package com.chowon.chownhub.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentService {
    private static final Logger log = LoggerFactory.getLogger(CommentService.class);

    private CommentRepository commentRepository;

    public void createComment(Comment comment) {
        commentRepository.create(comment);
    }

    public void updateComment(Comment comment) {
        commentRepository.update(comment);
    }

    public void deleteComment(long commentId) {
        commentRepository.delete(commentId);
    }
}
