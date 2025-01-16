package com.chowon.chownhub.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BoardServiceTest {

    MemoryBoardRepository repo = new MemoryBoardRepository();
    BoardService service = new BoardService(repo);

    @AfterEach
    public void afterEach() {
        repo.clear();
    }
    @Test
    public void 글쓰기테스트() {
        Board board = new Board(1L, "20250115", BoardSubject.NOTICE, "jinwon", "hello world", "hello world", 1L);
        service.createBoard(board);

        Board dbBoard = repo.findById(board.getBoardId());

        assertThat(board).isEqualTo(dbBoard);
    }

    @Test
    public void 글수정테스트() {
        Board board = new Board(1L, "20250115", BoardSubject.NOTICE, "jinwon", "hello world", "hello world", 1L);
        service.createBoard(board);

        Board dbBoard = repo.findById(board.getBoardId());
        dbBoard.setTitle("Hello world 222");

        service.updateBoard(dbBoard);

        assertThat(dbBoard.getTitle()).isEqualTo("Hello world 222");
    }

    @Test
    public void 좋아요테스트() {
        Board board = new Board(1L, "20250115", BoardSubject.NOTICE, "jinwon", "hello world", "hello world", 0L);
        service.createBoard(board);

        service.likeBoard(board.getBoardId());
        service.likeBoard(board.getBoardId());
        service.likeBoard(board.getBoardId());

        Board dbBoard = repo.findById(board.getBoardId());
        assertThat(dbBoard.getLike()).isEqualTo(3);
    }

    @Test
    public void 주제별글목록가져오기() {
        Board board1 = new Board(1L, "20250115", BoardSubject.NOTICE, "jinwon", "hello world", "hello world", 0L);
        Board board2 = new Board(2L, "20250115", BoardSubject.NOTICE, "jinwon", "hello world", "hello world", 0L);
        Board board3 = new Board(3L, "20250115", BoardSubject.SPECS, "jinwon", "hello world", "hello world", 0L);
        Board board4 = new Board(4L, "20250115", BoardSubject.SPECS, "jinwon", "hello world", "hello world", 0L);
        Board board5 = new Board(5L, "20250115", BoardSubject.HEART, "jinwon", "hello world", "hello world", 0L);

        service.createBoard(board1);
        service.createBoard(board2);
        service.createBoard(board3);
        service.createBoard(board4);
        service.createBoard(board5);

        List<Board> notices = service.getBoardsBySubject(BoardSubject.NOTICE);
        List<Board> specs = service.getBoardsBySubject(BoardSubject.SPECS);
        List<Board> hearts = service.getBoardsBySubject(BoardSubject.HEART);

        assertThat(notices.size()).isEqualTo(2);
        assertThat(specs.size()).isEqualTo(2);
        assertThat(hearts.size()).isEqualTo(1);
    }
}