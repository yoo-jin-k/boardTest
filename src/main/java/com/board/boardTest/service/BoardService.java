package com.board.boardTest.service;

import com.board.boardTest.persistence.model.Board;

import java.util.List;

public interface BoardService {

    public List<Board> selectAll() throws Exception;

    public int selectBoardId(int num) throws Exception;

    public Board UpdateView(int num) throws Exception;

    public int selectUpdate(Board board) throws Exception;

    public Board selectDelete(int num) throws Exception;

    public void insertBoard(Board board) throws Exception;



}
