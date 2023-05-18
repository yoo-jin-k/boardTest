package com.board.boardTest.service.Impl;

import com.board.boardTest.mapper.BoardMapper;
import com.board.boardTest.persistence.model.Board;
import com.board.boardTest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int maxNum(int num) throws Exception {
        return boardMapper.maxNum(num);
    }

    @Override
    public List<Board> selectAll() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public int selectBoardId(int num) throws Exception {
         boardMapper.selectReadData(num);
        return num;
    }

    @Override
    public void insertBoard(Board board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public Board UpdateView(int num) throws Exception {
        return boardMapper.updateViewCount(num);
    }

    @Override
    public int selectUpdate(Board board) throws Exception {
        return boardMapper.updateBoard(board);
    }

    @Override
    public Board selectDelete(int num) throws Exception {
        return boardMapper.deleteBoard(num);
    }


}
