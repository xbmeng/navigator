package com.example.navigator.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "分页结果")
public class Pagination {

    @ApiModelProperty("页码")
    private int page;

    @ApiModelProperty("记录总数")
    private int total;

    @ApiModelProperty("每页大小")
    private int size;

    public Pagination() { // NOSONAR
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
