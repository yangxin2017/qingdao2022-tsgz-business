package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewCarbon;
import com.bgd.tsgz.service.ViewCarbonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "碳排放", tags = {"碳排放"})
public class ViewCarbonController {
    @Autowired
    private ViewCarbonService viewCarbonService;

    @GetMapping("getCarbonHeatList")
    @ApiOperation(value = "获取碳排放热力", notes = "获取碳排放热力")
    public ResponseData<ViewCarbon> getCarbonHeatList() {
        QueryWrapper<ViewCarbon> queryWrapper = new QueryWrapper<>();

        return OK(viewCarbonService.list(queryWrapper));
    }
}
