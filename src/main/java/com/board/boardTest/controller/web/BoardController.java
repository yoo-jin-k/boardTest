package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.service.BoardService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/board/write")
    public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            model.addAttribute("board", new BoardDTO());
        } else {
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board == null) {
                return "redirect:/board/list";
            }
            model.addAttribute("board", board);
        }

        return "board/write";
    }

    @PostMapping(value = "/board/register")
    public String registerBoard(BoardDTO params) {

        int maxId = boardService.maxId();
        params.setIdx((long) (maxId + 1));
        boardService.registerBoard(params);
        System.out.println("++++++++++++++++++++++++++++++");
        return "redirect:/board/list";
    }

    @GetMapping(value = "/board/list")
    public String openBoardList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    @GetMapping(value = "/board/view")
    public String openBoardDetail(@ModelAttribute("params") BoardDTO params,
                                  @RequestParam(value = "idx", required = false) Long idx, Model model) {
//        if (idx == null) {
//            return null;
//        }
        boardService.getUpdateView(idx);
        BoardDTO board = boardService.getBoardDetail(idx);
//        if (board == null || "Y".equals(board.getDeleteYn())) {
//            return null;
//        }
        model.addAttribute("board", board);

        return "board/view";
    }

    @PostMapping(value = "/board/delete")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx) {
        if (idx == null) {
            return "redirect:/board/list";
        }

        try {
            int isDeleted = boardService.selectDeleteBoard(idx);
            if (isDeleted == 0) {
            }
        } catch (DataAccessException e) {
        } catch (Exception e) {
        }

        return "redirect:/board/list";
    }


}
