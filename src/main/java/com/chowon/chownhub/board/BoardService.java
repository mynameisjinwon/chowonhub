package com.chowon.chownhub.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardService {
    private static Logger log = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 글 작성
    public void createBoard(Board board) {
        boardRepository.create(board);
    }

    // 글 수정
    public void updateBoard(Board board) {
        boardRepository.update(board);
    }

    // 글 삭제
    public void deleteBoard(long boardId) {
        boardRepository.delete(boardId);
    }

    // 좋아요
    public void likeBoard(long boardId) {
        boardRepository.like(boardId);
    }
}
