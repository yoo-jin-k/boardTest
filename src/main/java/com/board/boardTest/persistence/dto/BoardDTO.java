package com.board.boardTest.persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

    private int num;

    private String title;

    private String name;

    private String content;

    private int hit;

}
