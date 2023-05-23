package com.board.boardTest.service.Impl;

import com.board.boardTest.mapper.ComCostMapper;
import com.board.boardTest.persistence.dto.ComCostDTO;
import com.board.boardTest.persistence.paging.PaginationInfo;
import com.board.boardTest.service.ComCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ComCostServiceImpl implements ComCostService {
    @Autowired
    private ComCostMapper comCostMapper;

    @Override
    public boolean registerComCost(ComCostDTO params) {
        int queryResult = 0;

        if (params.getCustCd() == null) {
            queryResult = comCostMapper.insertComCost(params);
        } else {
            queryResult = comCostMapper.updateComCost(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public ComCostDTO getComCostDetail(String custCd) {
        return comCostMapper.selectComCostDetail(custCd);
    }

    @Override
    public boolean deleteComCost(String custCd) {
        int queryResult = 0;

        ComCostDTO comCost = comCostMapper.selectComCostDetail(custCd);

        if (comCost != null && "N".equals(comCost.getDelYn())) {
            queryResult = comCostMapper.deleteComCost(custCd);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<ComCostDTO> getComCostList(ComCostDTO params) {
        List<ComCostDTO> comCostList = Collections.emptyList();

        int comCostTotalCount = comCostMapper.selectComCostTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(comCostTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (comCostTotalCount > 0) {
            comCostList = comCostMapper.selectComCostList(params);
        }

        return comCostList;
    }


}
