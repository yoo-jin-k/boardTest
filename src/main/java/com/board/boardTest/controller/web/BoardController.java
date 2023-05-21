package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.model.Board;
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
    public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
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
    public String registerBoard(final BoardDTO params) {
        try {
            boolean isRegistered = boardService.registerBoard(params);
            System.out.println("");
            if (isRegistered == false) {
                // TODO => 게시글 등록에 실패하였다는 메시지를 전달
            }
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
        }
        return "redirect:/board/list.do";
    }

    @GetMapping(value = "/board/list.do")
    public String openBoardList(Model model) {
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    @GetMapping(value = "/board/view.do")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        System.out.println("현재 -->" + this.getClass().getName() + "<-- 수행중..." );
        if (idx == null) {
            // TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list.do";
        }
        BoardDTO board = boardService.getBoardDetail(idx);
//        boardService.UpdateView(idx);
        if (board == null || "Y".equals(board.getDeleteYn())) {
            // TODO => 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list.do";
        }
        model.addAttribute("board", board);

        return "board/view";
    }

    @PostMapping(value = "/board/delete.do")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx) {
        if (idx == null) {
            // TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list.do";
        }

        try {
            boolean isDeleted = boardService.deleteBoard(idx);
            if (isDeleted == false) {
                // TODO => 게시글 삭제에 실패하였다는 메시지를 전달
            }
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
        }

        return "redirect:/board/list.do";
    }

}
