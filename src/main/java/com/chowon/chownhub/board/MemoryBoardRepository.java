package com.chowon.chownhub.board;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryBoardRepository implements BoardRepository {

    private static final Map<Long, Board> boards = new HashMap<>();
    private static long boardId = 0;

    @Override
    public void create(Board board) {
        board.setBoardId(boardId++);
        board.setLike(0L);
        board.setDate(getDateString());
        boards.put(board.getBoardId(), board);
    }

    @Override
    public Board findById(long boardId) {
        return boards.get(boardId);
    }

    @Override
    public List<Board> findBySubject(BoardSubject subject) {
        List<Board> all = findAll();
        List<Board> tmp = new ArrayList<>();
        for (Board board : all) {
            if (board.getSubject() == subject) {
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

    public void clear() {
        boards.clear();
    }

    private String getDateString() {
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 포맷 적용
        return now.format(formatter);
    }
}
