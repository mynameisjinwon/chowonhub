package com.chowon.chownhub.board;

import java.util.HashMap;
import java.util.Map;

public class MemoryBoardRepository implements BoardRepository {

    private static final Map<Long, Board> boards = new HashMap<>();

    @Override
    public void create(Board board) {
        boards.put(board.getBoardId(), board);
    }

    @Override
    public Board findById(long boardId) {
        return boards.get(boardId);
    }

    @Override
    public void update(Board board) {
        boards.put(board.getBoardId(), board);
    }

    @Override
    public void delete(long boardId) {
        boards.put(boardId, null);
    }

    @Override
    public void like(long boardId) {
        Board board = boards.get(boardId);
        board.setLike(board.getLike() + 1);
        boards.put(boardId, board);
    }
}
