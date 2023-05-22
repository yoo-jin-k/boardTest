package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.dto.PageDTO;
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

    @PostMapping({"/board/register.do"})
    public String registerBoard(final BoardDTO params) {
        try {
            boolean isRegistered = this.boardService.registerBoard(params);
            System.out.println("");
            if (!isRegistered) {
            }
        } catch (DataAccessException var3) {
        } catch (Exception var4) {
        }

        return "redirect:/board/list.do";
    }

    @GetMapping({"/board/list.do"})
    public String openBoardList(Model model,Criteria criteria) {
        List<BoardDTO> boardList = this.boardService.getBoardList(criteria);
        model.addAttribute("boardList", boardList);

        int total = boardService.getTotalCount(criteria);
        PageDTO pageMaker = new PageDTO(criteria, total);
        model.addAttribute("pageMaker", pageMaker);
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

    @PostMapping({"/board/delete.do"})
    public String deleteBoard(@RequestParam(value = "idx",required = false) Long idx) {
        if (idx == null) {
            return "redirect:/board/list.do";
        } else {
            try {
                boolean isDeleted = this.boardService.deleteBoard(idx);
                if (!isDeleted) {
                }
            } catch (DataAccessException var3) {
            } catch (Exception var4) {
            }

            return "redirect:/board/list.do";
        }
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
