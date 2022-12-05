package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.TrafficStop;
import com.bgd.tsgz.service.TrafficStopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "交通站点", tags = {"交通站点表"})
public class TrafficStopController {
    @Autowired
    private TrafficStopService trafficStopService;


    @GetMapping("getTrafficStopList")
    @ApiOperation(value = "获取航空交通站点列表", notes = "获取航空交通站点列表")
    public ResponseData getTrafficStopList() {
        QueryWrapper<TrafficStop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "1");
        return OK(trafficStopService.list(queryWrapper));
    }

    @GetMapping("getAutomobileStationList")
    @ApiOperation(value = "获取汽车站点列表", notes = "获取汽车站点列表")
    public ResponseData getAutomobileStationList() {
        QueryWrapper<TrafficStop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "2");
        return OK(trafficStopService.list(queryWrapper));
    }

    @GetMapping("getRailwayStationList")
    @ApiOperation(value = "获取铁路站点列表", notes = "获取铁路站点列表")
    public ResponseData getRailwayStationList() {
        QueryWrapper<TrafficStop> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "3");
        return OK(trafficStopService.list(queryWrapper));
    }

}
