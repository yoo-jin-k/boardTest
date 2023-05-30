package com.board.boardTest.service;

import com.board.boardTest.persistence.dto.BoardDTO;
import com.board.boardTest.persistence.dto.ComCostDTO;

import java.util.List;

public interface ComCostService {
    public ComCostDTO registerComCost(ComCostDTO params);
    public ComCostDTO getComCostDetail(String custCd);
    public boolean deleteComCost(String custCd);
    public List<ComCostDTO> getComCostList(ComCostDTO params);

    public void updateComCost(ComCostDTO params);




}
