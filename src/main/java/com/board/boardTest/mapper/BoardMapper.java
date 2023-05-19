package com.board.boardTest.mapper;

import com.board.boardTest.persistence.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public int maxId();
    public void insertBoard(BoardDTO params);
    public BoardDTO selectBoardDetail(Long idx);
    public int updateBoard(BoardDTO params);
//    public int deleteBoard(Long idx);
    public List<BoardDTO> selectBoardList();
    public int selectBoardTotalCount();
    public int selectDeleteBoard(Long idx);

    public int updateView(Long idx);

}
