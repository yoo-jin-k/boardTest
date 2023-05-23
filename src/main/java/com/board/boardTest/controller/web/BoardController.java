package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;

import com.board.boardTest.persistence.paging.Criteria;
import com.board.boardTest.service.BoardService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
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

    @GetMapping(value = "/board/write.do")
    public String openBoardWrite(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            model.addAttribute("board", new BoardDTO());
        } else {
            BoardDTO board = boardService.getBoardDetail(idx);
            if (board== null || "Y".equals(board.getDeleteYn())) {
                return "redirect:/board/list.do";
            }
            model.addAttribute("board", board);
        }

        return "board/write";
    }

    @PostMapping({"/board/register.do"})
    public String registerBoard(@ModelAttribute("params") final BoardDTO params, Model model) {
        Map<String, Object> pagingParams = getPagingParams(params);
        try {
            boolean isRegistered = boardService.registerBoard(params);
            if (isRegistered == false) {
                return "redirect:/board/list.do";
            }
        } catch (DataAccessException e) {
            return "redirect:/board/list.do";
        } catch (Exception e) {
            return "redirect:/board/list.do";
        }

        return "redirect:/board/list.do";
    }

    @GetMapping({"/board/list.do"})
    public String openBoardList(Model model,@ModelAttribute("params") BoardDTO params) {
        List<BoardDTO> boardList = this.boardService.getBoardList(params);
        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    @GetMapping(value = "/board/view.do")
    public String openBoardDetail(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "idx", required = false) Long idx, Model model) {
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
    public String deleteBoard(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "idx",required = false) Long idx) {
        if (idx == null) {
            return "redirect:/board/list.do";
        }
        Map<String, Object> pagingParams = getPagingParams(params);
        try {
            boolean isDeleted = boardService.deleteBoard(idx);
            if (isDeleted == false) {
                return "redirect:/board/list.do";
            }
        } catch (DataAccessException e) {
            return "redirect:/board/list.do";

        } catch (Exception e) {
            return "redirect:/board/list.do";
        }

        return "redirect:/board/list.do";
    }



    public Map<String, Object> getPagingParams(Criteria criteria) {

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("currentPageNo", criteria.getCurrentPageNo());
        params.put("recordsPerPage", criteria.getRecordsPerPage());
        params.put("pageSize", criteria.getPageSize());
        params.put("searchType", criteria.getSearchType());
        params.put("searchKeyword", criteria.getSearchKeyword());

        return params;
    }


}
