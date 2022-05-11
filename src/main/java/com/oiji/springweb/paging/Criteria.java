package com.oiji.springweb.paging;

import lombok.Data;

@Data
public class Criteria {
    /** 현재 페이지 번호 */
    private int page;

    /** 페이지당 출력할 데이터 개수 */
    private int records;

    /** 검색 키워드 */
    private String query;

    /** 검색 유형 */
    private String field;

    public Criteria() {
        this(1, 10, "", "title");
    }

    public Criteria(int page, int records, String query, String field) {
        this.page = page;
        this.records = records;
        this.query = query;
        this.field = field;
    }
}
