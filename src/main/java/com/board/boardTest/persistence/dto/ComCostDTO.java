package com.board.boardTest.persistence.dto;

import com.board.boardTest.persistence.paging.Criteria;
import com.board.boardTest.persistence.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComCostDTO extends Criteria {

    private PaginationInfo paginationInfo;

    private String bizCd;
    private String custCd;
    private String custNm;
    private String abbrNm;
    private String bizregNo;
    private String bizType;
    private String ceoNm;
    private String compNm;
    private String addr1;
    private String addr2;
    private String zipCd;
    private String tel1;
    private String tel2;
    private String fax;
    private String email;
    private int orderNum;
    private String rmk;
    private String useYn;
    private String delYn;
    private String regId;
    private String regDt;
    private String modId;
    private String modDt;
    private String picNm;
    private String picTel;

}
