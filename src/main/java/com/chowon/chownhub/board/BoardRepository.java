package com.chowon.chownhub.board;

import java.util.List;

public interface BoardRepository {
    void create(Board board);

    Board findById(long boardId);

    List<Board> findBySubject(String subject);

    List<Board> findAll();

    void update(Board board);

    void delete(long boardId);

    void like(long boardId);

}
