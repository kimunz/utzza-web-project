package com.oiji.springweb.paging;

import lombok.Data;

@Data
public class Criteria {
    /** 현재 페이지 번호 */
    private int page;

    /** 페이지당 출력할 데이터 개수 */
    private int records;

    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageSize;

    /** 검색 키워드 */
    private String query;

    /** 검색 유형 */
    private String field;

    public Criteria() {
        this.page = 1;
        this.records = 10;
        this.pageSize = 5;
    }

    public int getStartPage() {
        return (page - 1) * records;
    }
}
