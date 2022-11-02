package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewInduce;
import com.bgd.tsgz.service.ViewInduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "诱导", tags = {"诱导"})
public class ViewInduceController {
    @Autowired
    private ViewInduceService viewInduceService;

    @GetMapping("getInduceList")
    @ApiOperation(value = "获取诱导列表", notes = "获取诱导列表")
    public ResponseData<ViewInduce> getInduceList() {
        QueryWrapper<ViewInduce> queryWrapper = new QueryWrapper<>();

        return OK(viewInduceService.list(queryWrapper));
    }
}
