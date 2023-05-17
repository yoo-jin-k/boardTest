package com.board.boardTest.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor // 생성자 주입
@RequestMapping("/board")
public class BoardController {

//    service

    public String boardList(Model model) throws Exception {
        return null;
    }
}
