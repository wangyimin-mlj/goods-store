package com.mlj.it.goods.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.awt.print.PageFormat;
import java.awt.print.Printable;

public class MongoPageable implements Pageable {
    // 当前页
    private Integer pagenumber = 1;
    // 当前页面条数
    private Integer pagesize = 2;
    // 排序条件
    private Sort sort;

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return getPagenumber();
    }

    @Override
    public int getPageSize() {
        return getPagesize();
    }

    @Override
    public long getOffset() {
        return (getPageNumber() - 1) * getPagesize();
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

}
