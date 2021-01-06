package com.wqh.jpa.entity;

import lombok.Data;

/**
 * @ClassName PageInfo
 * @Author wqh
 * @Date 2021/1/5 14:30
 * @Description TODO
 * @Version 1.0
 */
@Data
public class PageInfo {

    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalPages;
    private Integer total;

    public PageInfo(Integer pageIndex, Integer pageSize, Integer totalPages, Integer total) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.total = total;
    }
}
