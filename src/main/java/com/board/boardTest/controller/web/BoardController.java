package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.model.Board;
import com.board.boardTest.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    @Resource
    private BoardService boardService;
    @RequestMapping(value = "/")
    public ModelAndView index() throws Exception{

        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");

        return mav;
    }

    @GetMapping("/list")
    public String boardList(Model model) throws Exception {
        List<Board> lists = boardService.selectAll();
        model.addAttribute("lists", lists);
        System.out.println("****************************"+lists+"****************************");
        return "/board/list";
    }

    @GetMapping("/detail/{num}")
    public String boardDetail(@PathVariable int num,Model model) throws Exception {
        int board = boardService.selectBoardId(num);
        model.addAttribute("board", board);
        return "/board/detail";
    }

//    추가

    @GetMapping("/board/insert")
    public String boardInsertview(Board board,Model model) throws Exception {
        return "/board/insert";
    }

    @PostMapping("/board/insert")
    public String boardInsert(int num,Board board, Model model, HttpServletRequest request ) throws Exception {

        boardService.UpdateView(num);
        boardService.insertBoard(board);
        model.addAttribute("board",board);
        return "board/insert";
    }

    //    수정
    @GetMapping("/board/update/{num}")
    public String boardUpdateView() {
        return "board/update";
    }
    @PostMapping("/board/update/{num}")
    public String boardUpdate(@ModelAttribute Board board,Model model) throws Exception {
        boardService.selectUpdate(board);
        return "board/update";
    }

//    삭제
    @PostMapping("/board/delete/{num}")
    public String boardDelete(@PathVariable int num,Model model) throws Exception {
        boardService.selectDelete(num);
        return "board/list";
    }



//    페이징

//    public String boardPaging(Model model) throws Exception {
//        return null;
//    }

//    검색
//    public String boardSearch(Model model) throws Exception {
//        return null;
//    }


}
