package com.board.boardTest.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {

    private Long boardId;

    private String title;

    private String name;

    private String content;

    private int hit;

    private String create;
}
