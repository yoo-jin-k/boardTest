package com.board.boardTest.service.Impl;

import com.board.boardTest.mapper.BoardMapper;
import com.board.boardTest.persistence.dto.BoardDTO;

import com.board.boardTest.persistence.paging.PaginationInfo;
import com.board.boardTest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean registerBoard(BoardDTO params) {
        int queryResult = 0;

        if (params.getIdx() == null) {
            queryResult = boardMapper.insertBoard(params);
        } else {
            queryResult = boardMapper.updateBoard(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        BoardDTO board = boardMapper.selectBoardDetail(idx);

        if (board != null && "N".equals(board.getDeleteYn())) {
            queryResult = boardMapper.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

//    @Override
//    public List<BoardDTO> getBoardList(BoardDTO params) {
//        List<BoardDTO> boardList = Collections.emptyList();
//
//        int boardTotalCount = boardMapper.selectBoardTotalCount(params);
//        PaginationInfo paginationInfo = new PaginationInfo(params);
//        paginationInfo.setTotalRecordCount(boardTotalCount);
//
//        params.setPaginationInfo(paginationInfo);
//
//        if (boardTotalCount > 0) {
//            boardList = boardMapper.selectBoardList(params);
//        }
//
//        return boardList;
//    }

    @Override
    public List<BoardDTO> getBoardList(BoardDTO params) {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(boardTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList(params);
        }

        return boardList;
    }

//    @Override
//    public int getTotalCount(Criteria criteria) {
//        return boardMapper.selectBoardTotalCount(criteria);
//    }


    @Override
    public int UpdateView(Long idx) {
        return boardMapper.updateViewCount(idx);
    }



}
