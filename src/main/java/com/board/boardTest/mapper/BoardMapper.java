package com.board.boardTest.mapper;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.model.Board;
import com.board.boardTest.persistence.page.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

//    public int insertBoard(BoardDTO params);
//    public BoardDTO selectBoardDetail(Long idx);
//    public int updateBoard(BoardDTO params);
//    public int deleteBoard(Long idx);
//    public List<BoardDTO> selectBoardList(BoardDTO params);
//
//    public int updateViewCount(Long idx);
//
//    public int selectBoardTotalCount(BoardDTO params);


    public int insertBoard(BoardDTO params);
    public BoardDTO selectBoardDetail(Long idx);
    public int updateBoard(BoardDTO params);
    public int deleteBoard(Long idx);
    public List<BoardDTO> selectBoardList(Criteria criteria);
    public int selectBoardTotalCount(Criteria criteria);
    public int updateViewCount(Long idx);
}
