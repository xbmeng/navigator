package com.example.navigator.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "分页结果")
public class Page<E> {

    @ApiModelProperty("分页信息")
    private Pagination pagination;

    @ApiModelProperty("数据")
    private List<E> data;

    public Page() { // NOSONAR
    }

    public Pagination getPagination() {
            return pagination;
        }

    public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }

    public List<E> getData() {
            return data;
        }

    public void setData(List<E> data) {
            this.data = data;
        }
    }

