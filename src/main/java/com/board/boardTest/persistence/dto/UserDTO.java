package com.board.boardTest.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    private Long userId;

    private String name;

    private String password;
}
