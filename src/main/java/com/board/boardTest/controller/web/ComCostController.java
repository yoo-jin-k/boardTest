package com.board.boardTest.controller.web;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.dto.ComCostDTO;
import com.board.boardTest.persistence.paging.Criteria;
import com.board.boardTest.service.ComCostService;
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
public class ComCostController {

    @Resource
    private ComCostService comCostService;
//    @RequestMapping(value = "/")
//    public ModelAndView index() throws Exception{
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("main");
//
//        return mav;
//    }

    @GetMapping(value = "/comCost/write.do")
    public String openComCostWrite(@ModelAttribute("params") BoardDTO params,@RequestParam(value = "custCd", required = false) String custCd, Model model) {
        if (custCd == null) {
            model.addAttribute("comCost", new ComCostDTO());
        } else {
            ComCostDTO comCost = comCostService.getComCostDetail(custCd);
            if (comCost== null || "Y".equals(comCost.getDelYn())) {
                return "redirect:/comCost/list.do";
            }
            model.addAttribute("comCost", comCost);
        }

        return "comCost/write";
    }

    @PostMapping({"/comCost/register.do"})
    public String registerComCost(@ModelAttribute("params") final ComCostDTO params, Model model) {
        Map<String, Object> pagingParams = getPagingParams(params);
        try {
            boolean isRegistered = comCostService.registerComCost(params);
            if (isRegistered == false) {
                return "redirect:/comCost/list.do";
            }
        } catch (DataAccessException e) {
            return "redirect:/comCost/list.do";
        } catch (Exception e) {
            return "redirect:/comCost/list.do";
        }

        return "redirect:/comCost/list.do";
    }

    @GetMapping({"/comCost/list.do"})
    public String openComCostList(Model model,@ModelAttribute("params") ComCostDTO params) {
        List<ComCostDTO> comCostList = this.comCostService.getComCostList(params);
        model.addAttribute("comCostList", comCostList);

        return "comCost/list";
    }

    @GetMapping(value = "/comCost/view.do")
    public String openBoardDetail(@ModelAttribute("params") ComCostDTO params,@RequestParam(value = "custCd", required = false) String custCd, Model model) {
        if (custCd == null) {
            return "redirect:/comCost/list.do";
        }
        ComCostDTO comCost = comCostService.getComCostDetail(custCd);
//        boardService.UpdateView(idx);
        if (comCost == null || "Y".equals(comCost.getDelYn())) {
            return "redirect:/board/list.do";
        }
        model.addAttribute("comCost", comCost);

        return "comCost/view";
    }

    @PostMapping({"/comCost/delete.do"})
    public String deleteBoard(@ModelAttribute("params") ComCostDTO params,@RequestParam(value = "custCd",required = false) String custCd) {
        if (custCd == null) {
            return "redirect:/board/list.do";
        }
        Map<String, Object> pagingParams = getPagingParams(params);
        try {
            boolean isDeleted = comCostService.deleteComCost(custCd);
            if (isDeleted == false) {
                return "redirect:/comCost/list.do";
            }
        } catch (DataAccessException e) {
            return "redirect:/comCost/list.do";

        } catch (Exception e) {
            return "redirect:/comCost/list.do";
        }

        return "redirect:/comCost/list.do";
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
