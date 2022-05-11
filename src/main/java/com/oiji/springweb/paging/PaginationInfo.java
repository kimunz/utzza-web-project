package com.oiji.springweb.paging;


import lombok.Data;

@Data
public class PaginationInfo {

    private Criteria criteria;
    private int pageSize;
    private int totalRecords;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean prev, next;

    public PaginationInfo(Criteria criteria, int totalRecords, int pageSize) {
        this.criteria = criteria;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        totalPages = totalRecords / criteria.getRecords() + 1;

        endPage = (int) (Math.ceil(criteria.getPage() * 0.1) / pageSize) * pageSize;
        startPage = endPage - (pageSize-1);

        if (endPage > totalPages) {
            endPage = totalPages;
        }

        prev = startPage > 1;
        next = endPage < totalPages;
    }
}
