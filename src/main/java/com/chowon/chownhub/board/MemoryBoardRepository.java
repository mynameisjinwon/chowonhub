package com.chowon.chownhub.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
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
    public List<Board> findBySubject(String subject) {
        List<Board> all = findAll();
        List<Board> tmp = new ArrayList<>();
        for (Board board : all) {
            if (board.getSubject().equals(subject)) {
                tmp.add(board);
            }
        }
        return tmp;
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(boards.values());
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
