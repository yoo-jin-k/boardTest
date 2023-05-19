package com.board.boardTest.service.Impl;

import com.board.boardTest.mapper.BoardMapper;
import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

//    @Override
//    public boolean registerBoard(BoardDTO params) {
//        int queryResult = 0;
//
//        if (params.getIdx() == null) {
//            queryResult = boardMapper.insertBoard(params);
//        } else {
//            queryResult = boardMapper.updateBoard(params);
//        }
//
//        return (queryResult == 1) ? true : false;
//    }

    @Override
    public int maxId() {
        return boardMapper.maxId();
    }

    @Override
    public void registerBoard(BoardDTO params) {
        boardMapper.insertBoard(params);
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

//    @Override
//    public boolean deleteBoard(Long idx) {
//        int queryResult = 0;
//
//        BoardDTO board = boardMapper.selectBoardDetail(idx);
//
//        if (board != null && "N".equals(board.getDeleteYn())) {
//            queryResult = boardMapper.deleteBoard(idx);
//        }
//
//        return (queryResult == 1) ? true : false;
//    }

    @Override
    public int selectDeleteBoard(Long idx) {
        return boardMapper.selectDeleteBoard(idx);
    }


    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount();

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList();
        }

        return boardList;
    }

    @Override
    public int getUpdateView(Long idx) {
        return boardMapper.updateView(idx);
    }

}
