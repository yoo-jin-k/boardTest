package com.board.boardTest.mapper;

import com.board.boardTest.persistence.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int maxNum(int num) throws Exception;

    List<Board> selectBoardList() throws Exception;

    Board selectReadData(int boardId) throws Exception;

    void insertBoard(Board board) throws Exception;

    Board updateViewCount(int boardId) throws Exception;

    int updateBoard(Board board) throws Exception;

    Board deleteBoard(int boardId) throws Exception;


}
