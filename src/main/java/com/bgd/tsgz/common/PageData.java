package com.bgd.tsgz.common;

import lombok.Data;

import java.util.List;

@Data
public class PageData<T> {
    private Long total;
    private List<T> data;
}
