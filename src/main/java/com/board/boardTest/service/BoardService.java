package com.board.boardTest.service;

import com.board.boardTest.persistence.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public int maxId();
    public void registerBoard(BoardDTO params);
    public BoardDTO getBoardDetail(Long idx);
    public int selectDeleteBoard(Long idx);
    public List<BoardDTO> getBoardList();

    public int getUpdateView(Long idx);

}
