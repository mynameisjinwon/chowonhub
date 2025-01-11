package com.chowon.chownhub.board;

public interface BoardRepository {
    void create(Board board);

    Board findById(long boardId);

    void update(Board board);

    void delete(long boardId);

    void like(long boardId);

}
