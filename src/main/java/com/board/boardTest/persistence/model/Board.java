package com.board.boardTest.persistence.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {
    private int num;

    private String title;

    private String name;

    private String content;

    private int hit;
}
