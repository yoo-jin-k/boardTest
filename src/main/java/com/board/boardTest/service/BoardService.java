package com.board.boardTest.service;

import com.board.boardTest.persistence.dto.BoardDTO;


import java.util.List;

public interface BoardService {

//    public boolean registerBoard(BoardDTO params);
//    public BoardDTO getBoardDetail(Long idx);
//    public boolean deleteBoard(Long idx);
//    public List<BoardDTO> getBoardList(BoardDTO params);
//
//    public int UpdateView(Long idx);

    public boolean registerBoard(BoardDTO params);
    public BoardDTO getBoardDetail(Long idx);
    public boolean deleteBoard(Long idx);
    public List<BoardDTO> getBoardList(BoardDTO params);

//    public int getTotalCount(Criteria criteria);

    public int UpdateView(Long idx);


}
