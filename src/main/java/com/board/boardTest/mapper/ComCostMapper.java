package com.board.boardTest.mapper;


import com.board.boardTest.persistence.dto.ComCostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComCostMapper {
    public int insertComCost(ComCostDTO params);
    public ComCostDTO selectComCostDetail(String custCd);
    public int updateComCost(ComCostDTO params);
    public int deleteComCost(String custCd);
    public List<ComCostDTO> selectComCostList(ComCostDTO params);
    public int selectComCostTotalCount(ComCostDTO params);
}
