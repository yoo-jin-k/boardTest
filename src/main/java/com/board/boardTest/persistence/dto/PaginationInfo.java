package com.board.boardTest.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationInfo {

    //페이징 계산에 필요함 클래스 만들기

    // 전체 데이터 개수
    private int totalRecordCount;

    // 전체 페이지 개수 */
    private int totalPageCount;

    // 페이지 리스트의 첫 페이지 번호
    private int firstPage;

    // 페이지 리스트의 마지막 페이지 번호
    private int lastPage;

    // SQL의 조건절에 사용되는 첫 RNUM
    private int firstRecordIndex;

    // SQL의 조건절에 사용되는 마지막 RNUM
    private int lastRecordIndex;

    // 이전 페이지 존재 여부
    private boolean hasPreviousPage;

    // 다음 페이지 존재 여부
    private boolean hasNextPage;

}
