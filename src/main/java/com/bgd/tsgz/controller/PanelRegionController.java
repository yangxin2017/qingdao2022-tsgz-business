package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.entity.CityEvaluate;
import com.bgd.tsgz.entity.RegionEvaluate;
import com.bgd.tsgz.service.DriveService;
import com.bgd.tsgz.service.RegionEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "面板数据-区域级", tags = {"面板数据-区域级"})
public class PanelRegionController {

    @Autowired
    private DriveService driveService;
    @Autowired
    private RegionEvaluateService regionEvaluateService;

    @GetMapping("getDriveInList")
    @ApiOperation(value = "获取驶入车辆周期数据", notes = "获取驶入车辆周期数据")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取驶入车辆周期数据")
    public ResponseData<AcdFile> getDriveInList(){
        return OK(driveService.getDriveInCycle());
    }

    @GetMapping("getDriveOutList")
    @ApiOperation(value = "获取驶出车辆周期数据", notes = "获取驶出车辆周期数据")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取驶出车辆周期数据")
    public ResponseData<AcdFile> getDriveOutList(){
        return OK(driveService.getDriveOutCycle());
    }

    @GetMapping("getDriveIn24Hour")
    @ApiOperation(value = "获取24小时驶入车辆变化趋势", notes = "获取24小时驶入车辆变化趋势")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取24小时驶入车辆变化趋势")
    public ResponseData<AcdFile> getDriveIn24Hour(){
        return OK(driveService.getDriveIn24Hour());
    }

    @GetMapping("getDriveOut24Hour")
    @ApiOperation(value = "获取24小时驶出车辆变化趋势", notes = "获取24小时驶出车辆变化趋势")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取24小时驶出车辆变化趋势")
    public ResponseData<AcdFile> getDriveOut24Hour(){
        return OK(driveService.getDriveOut24Hour());
    }

    @GetMapping("getCongestionIndex")
    @ApiOperation(value = "获取拥堵指数", notes = "获取拥堵指数")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取拥堵指数")
    public ResponseData<AcdFile> getCongestionIndex(){
        return OK(driveService.getCongestionIndex());
    }

    @GetMapping("getAverageSpeed")
    @ApiOperation(value = "获取平均速度", notes = "获取平均速度")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取平均速度")
    public ResponseData<AcdFile> getAverageSpeed(){
        return OK(driveService.getAverageSpeed());
    }

    @GetMapping("getTransitnum")
    @ApiOperation(value = "获取在途车辆", notes = "获取在途车辆")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取在途车辆")
    public ResponseData<AcdFile> getTransitnum(){
        return OK(driveService.getTransitnum());
    }

    @GetMapping("getRank")
    @ApiOperation(value = "获取指数和速度排名", notes = "获取指数和速度排名")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取指数和速度排名")
    public ResponseData<AcdFile> getRank(){
        return OK(driveService.getRank());
    }

    @GetMapping("getSectionFlow")
    @ApiOperation(value = "获取流量排名", notes = "获取流量排名")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取流量排名")
    public ResponseData<AcdFile> getSectionFlow(){
        return OK(driveService.getSectionFlow());
    }

    // 获取区域路段排名
    @GetMapping("getSectionRank")
    @ApiOperation(value = "获取区域路段排名", notes = "获取区域路段排名")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域路段排名")
    public ResponseData<AcdFile> getSectionRank(){
        return OK(driveService.getSectionRank());
    }


    // 获取区域头部
    @GetMapping("getRegionHead")
    @ApiOperation(value = "获取区域头部", notes = "获取区域头部")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域头部")
    public ResponseData<AcdFile> getRegionHead(){
        return OK(driveService.getRegionHead());
    }


    @GetMapping("getRegionEvaluate")
    @ApiOperation(value = "区域综合评分", notes = "区域综合评分")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域综合评分")
    public ResponseData getRegionEvaluate() {
        QueryWrapper<RegionEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","1");
        return OK(regionEvaluateService.list(queryWrapper));
    }


    // 城市群综合评价
    @GetMapping("getRegionEvaluateList")
    @ApiOperation(value = "区域综合评价", notes = "区域综合评价")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域综合评价")
    public ResponseData getRegionEvaluateList() {
        QueryWrapper<RegionEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","2");
        return OK(regionEvaluateService.list(queryWrapper));
    }

    // 城市群安全评分
    @GetMapping("getRegionEvaluateSafe")
    @ApiOperation(value = "区域安全评分", notes = "区域安全评分")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域安全评分")
    public ResponseData getRegionEvaluateSafe() {
        QueryWrapper<RegionEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","3");
        return OK(regionEvaluateService.list(queryWrapper));
    }

    // 高效
    @GetMapping("getRegionEvaluateEfficient")
    @ApiOperation(value = "区域高效评分", notes = "区域高效评分")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取区域高效评分")
    public ResponseData getRegionEvaluateEfficient() {
        QueryWrapper<RegionEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","4");
        return OK(regionEvaluateService.list(queryWrapper));
    }

    @GetMapping("getRegionTpi24List")
    @ApiOperation(value = "交通指数/拥堵指数24小时", notes = "交通指数/拥堵指数24小时")
    @RequestLog(moduleName = "区域级数据面板",functionName = "获取交通指数/拥堵指数24小时")
    public ResponseData<AcdFile> getRegionTpi24List(String type,String time) throws Exception {
        JSONObject result = regionEvaluateService.getRegionTpi24List(type,time);
        return OK(result);
    }
}