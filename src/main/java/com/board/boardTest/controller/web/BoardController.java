package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.model.Board;
import com.board.boardTest.persistence.page.Criteria;
import com.board.boardTest.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @GetMapping(value = "/board/write.do")
    public String openBoardWrite(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            model.addAttribute("board", new BoardDTO());
        } else {
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board == null) {
                return "redirect:/board/list.do";
            }
            model.addAttribute("board", board);
        }

        return "board/write";
    }

    @PostMapping(value = "/board/register.do")
    public String registerBoard(@ModelAttribute("params") final BoardDTO params, Model model) {
//        List<Object> pagingParams = getPagingParams(params);
        try {
            boolean isRegistered = boardService.registerBoard(params);
            System.out.println("");
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
        }
        return "redirect:/board/list.do";
    }

    @GetMapping(value = "/board/list.do")
    public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
        List<BoardDTO> boardList = boardService.getBoardList(params);
        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    @GetMapping(value = "/board/view.do")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            return "redirect:/board/list.do";
        }
        BoardDTO board = boardService.getBoardDetail(idx);
//        boardService.UpdateView(idx);
        if (board == null || "Y".equals(board.getDeleteYn())) {
            return "redirect:/board/list.do";
        }
        model.addAttribute("board", board);

        return "board/view";
    }

    @PostMapping(value = "/board/delete.do")
    public String deleteBoard(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "idx", required = false) Long idx) {
        if (idx == null) {
            return "redirect:/board/list.do";
        }
//        List<Object> pagingParams = getPagingParams(params);
        try {
            boolean isDeleted = boardService.deleteBoard(idx);
            if (isDeleted == false) {

            }
        } catch (DataAccessException e) {
        } catch (Exception e) {
        }

        return "redirect:/board/list.do";
    }

//    public List<Object> getPagingParams(Criteria criteria) {
//        List<Object> params = new ArrayList<>();
//        params.add(criteria.getCurrentPageNo());
//        params.add(criteria.getRecordsPerPage());
//        params.add(criteria.getPageSize());
//        params.add(criteria.getSearchType());
//        params.add(criteria.getSearchKeyword());
//
//        return params;
//    }


}
