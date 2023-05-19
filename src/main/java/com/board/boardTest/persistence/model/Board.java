package com.board.boardTest.persistence.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private String noticeYn;
    private String secretYn;
}
