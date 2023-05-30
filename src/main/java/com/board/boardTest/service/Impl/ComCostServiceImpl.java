package com.board.boardTest.service.Impl;

import com.board.boardTest.mapper.ComCostMapper;
import com.board.boardTest.persistence.dto.ComCostDTO;
import com.board.boardTest.persistence.paging.PaginationInfo;
import com.board.boardTest.service.ComCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ComCostServiceImpl implements ComCostService {
    @Autowired
    private ComCostMapper comCostMapper;

//    @Override
//    public boolean registerComCost(ComCostDTO params) {
//        int queryResult = 0;
//
//        if (params.getCustCd() == null) {
//            queryResult = comCostMapper.insertComCost(params);
//        } else {
//            queryResult = comCostMapper.updateComCost(params);
//        }
//
//        return (queryResult == 1) ? true : false;
//    }

    @Override
    public ComCostDTO registerComCost(ComCostDTO params) {

        // custCd 부분 생성
        String id = "CUST_";
        // 현재 날짜 가지고오기
        LocalDate localDate = LocalDate.now();
        // 날짜를 "yyyMMdd" 형식으로 포맷
        String nowLocalData = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // 포맷된 날짜를 custCd에 추가
        id = id + nowLocalData;

        // 동일한 등록일자로 기존 데이터를 검색하기 위한 comCostDTO 객체 생성
        ComCostDTO searchData = new ComCostDTO();
        searchData.setRegDt(nowLocalData);
        // 동일한 등록일자를 가진 기존 ComCostDTO 객체의 총 개수 가져오기
        int i = comCostMapper.selectComCostTotalCount(searchData);
        // 개수를 문자열로 변환하고 선행 0이 포함된 형식으로 변환
        id = id + "_" + Integer.toString(Integer.parseInt(String.format("%3d", i).trim()));

        // 생성된 custCd를 params 객체에 설정
        params.setCustCd(id);

        // comCostMapper를 사용하여 ComCostDTO 객체를 데이터베이스에 삽입
        comCostMapper.insertComCost(params);

        // 새로운 ComCostDTO 객체 반환
        return new ComCostDTO();
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

    @Override
    public void updateComCost(ComCostDTO params) {
        comCostMapper.updateComCost(params);
    }

}
