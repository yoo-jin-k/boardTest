package com.board.boardTest.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/main/test")
    public String main(Model model) {
        model.addAttribute("test","test");
        return "test";
    }
}
