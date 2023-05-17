package com.board.boardTest.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BoardMainController {

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("test","main");
        return "main";
    }
}
