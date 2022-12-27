package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.TravelScale;
import com.bgd.tsgz.service.TravelScaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "出行规模", tags = {"出行规模"})
public class TravelScaleController {
    @Autowired
    private TravelScaleService TravelScaleService;


    @GetMapping("getTravelScaleList")
    @ApiOperation(value = "获取出行规模", notes = "获取出行规模")
    @RequestLog(moduleName = "出行规模",functionName = "获取出行规模")
    public ResponseData<TravelScale> getTravelScaleList() {
        QueryWrapper<TravelScale> queryWrapper = new QueryWrapper<>();
        return OK(TravelScaleService.list(queryWrapper));
    }
}
