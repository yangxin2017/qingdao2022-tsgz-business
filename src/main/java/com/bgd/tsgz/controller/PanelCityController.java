package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.*;
import com.bgd.tsgz.service.CityEvaluateService;
import com.bgd.tsgz.service.PanelCityService;
import com.bgd.tsgz.service.ProblemDiagnosisService;
import com.bgd.tsgz.service.TravelSharingService;
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
@Api(value = "面板数据-城市级", tags = {"面板数据-城市级"})
public class PanelCityController {

    @Autowired
    private PanelCityService panelCityService;
    @Autowired
    private CityEvaluateService cityEvaluateService;
    @Autowired
    private ProblemDiagnosisService problemDiagnosisService;
    @Autowired
    private TravelSharingService travelSharingService;


    @GetMapping("getTpiList")
    @ApiOperation(value = "交通指数/拥堵指数", notes = "交通指数/拥堵指数")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取交通指数/拥堵指数")
    public ResponseData<AcdFile> getTpiList(){
        JSONObject result = panelCityService.getTpiList();
        return OK(result);
    }

    @GetMapping("getTpi24List")
    @ApiOperation(value = "交通指数/拥堵指数24小时", notes = "交通指数/拥堵指数24小时")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取交通指数/拥堵指数24小时")
    public ResponseData<AcdFile> getTpi24List(String type,String time,String areaCode) throws ParseException {
        JSONObject result = panelCityService.getTpi24List(type,time,areaCode);
        return OK(result);
    }

    @GetMapping("getAvgSpeedList")
    @ApiOperation(value = "平均速度", notes = "平均速度")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取平均速度")
    public ResponseData<AcdFile> getAvgSpeedList(){
        JSONObject result = panelCityService.getAvgSpeedList();
        return OK(result);
    }

    @GetMapping("getTransitnumList")
    @ApiOperation(value = "在途车辆", notes = "在途车辆")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取在途车辆")
    public ResponseData<AcdFile> getTransitnumList(){
        JSONObject result = panelCityService.getTransitnumList();
        return OK(result);
    }

    @GetMapping("getCongestionRanking")
    @ApiOperation(value = "区域拥堵排名", notes = "区域拥堵排名")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取区域拥堵排名")
    public ResponseData<AcdFile> getCongestionRanking(){
        JSONArray result = panelCityService.getCongestionRanking();
        return OK(result);
    }

    @GetMapping("getFocusAreaRanking")
    @ApiOperation(value = "重点区域拥堵排名", notes = "重点区域拥堵排名")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取重点区域拥堵排名")
    public ResponseData<AcdFile> getFocusAreaRanking(){
        JSONArray result = panelCityService.getFocusAreaRanking();
        return OK(result);
    }

    @GetMapping("getRoadCongestionRanking")
    @ApiOperation(value = "路段拥堵排名", notes = "路段拥堵排名")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取路段拥堵排名")
    public ResponseData<AcdFile> getRoadCongestionRanking(){
        JSONArray result = panelCityService.getRoadCongestionRanking();
        return OK(result);
    }

    @GetMapping("getHighwayCongestionRanking")
    @ApiOperation(value = "高速拥堵排名", notes = "高速拥堵排名")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取高速拥堵排名")
    public ResponseData<AcdFile> getHighwayCongestionRanking(){
        JSONArray result = panelCityService.getHighwayCongestionRanking();
        return OK(result);
    }

    @GetMapping("getFocusRoadRanking")
    @ApiOperation(value = "重点路段排名", notes = "重点路段排名")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取重点路段排名")
    public ResponseData<AcdFile> getFocusRoadRanking(){
        JSONArray result = panelCityService.getFocusRoadRanking();
        return OK(result);
    }

    @GetMapping("getParkingList")
    @ApiOperation(value = "停车场", notes = "停车场")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取停车场数据")
    public ResponseData<AcdFile> getParkingList(String areaCode){
        JSONObject result = panelCityService.getParkingList(areaCode);
        return OK(result);
    }

    @GetMapping("getCityOverview")
    @ApiOperation(value = "城市概况", notes = "城市概况")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市概况")
    public ResponseData<AcdFile> getCityOverview(){
        JSONArray result = panelCityService.getCityOverview();
        return OK(result);
    }
    @GetMapping("getCityEvaluate")
    @ApiOperation(value = "城市综合评分", notes = "城市综合评分")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市综合评分")
    public ResponseData getCityEvaluate() {
        QueryWrapper<CityEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","1");
        return OK(cityEvaluateService.list(queryWrapper));
    }


    // 城市群综合评价
    @GetMapping("getCityEvaluateList")
    @ApiOperation(value = "城市综合评价", notes = "城市综合评价")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市综合评价")
    public ResponseData getCityEvaluateList() {
        QueryWrapper<CityEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","2");
        return OK(cityEvaluateService.list(queryWrapper));
    }

    // 城市群安全评分
    @GetMapping("getCityEvaluateSafe")
    @ApiOperation(value = "城市安全评分", notes = "城市安全评分")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市安全评分")
    public ResponseData getCityEvaluateSafe() {
        QueryWrapper<CityEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","3");
        return OK(cityEvaluateService.list(queryWrapper));
    }

    // 高效
    @GetMapping("getCityEvaluateEfficient")
    @ApiOperation(value = "城市高效评分", notes = "城市高效评分")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市高效评分")
    public ResponseData getCityEvaluateEfficient() {
        QueryWrapper<CityEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","4");
        return OK(cityEvaluateService.list(queryWrapper));
    }

    // 便捷
    @GetMapping("getCityEvaluateConvenient")
    @ApiOperation(value = "城市便捷评分", notes = "城市便捷评分")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市便捷评分")
    public ResponseData getCityEvaluateConvenient() {
        QueryWrapper<CityEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","5");
        return OK(cityEvaluateService.list(queryWrapper));
    }

    @GetMapping("getCityEvaluateProblemDiagnosis")
    @ApiOperation(value = "城市问题诊断", notes = "城市问题诊断")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取城市问题诊断")
    public ResponseData getCityEvaluateProblemDiagnosis() {
        QueryWrapper<ProblemDiagnosis> queryWrapper = new QueryWrapper<>();
        return OK(problemDiagnosisService.list(queryWrapper));
    }

    @GetMapping("getSurfaceBus")
    @ApiOperation(value = "地面公交", notes = "地面公交")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取地面公交数据")
    public ResponseData getSurfaceBus() {
        QueryWrapper<TravelSharing> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","1");
        return OK(travelSharingService.list(queryWrapper));
    }

    @GetMapping("getRailway")
    @ApiOperation(value = "轨道交通", notes = "轨道交通")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取轨道交通数据")
    public ResponseData getRailway() {
        QueryWrapper<TravelSharing> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","2");
        return OK(travelSharingService.list(queryWrapper));
    }

    @GetMapping("getTaxi")
    @ApiOperation(value = "出租车", notes = "出租车")
    @RequestLog(moduleName = "城市级数据面板",functionName = "获取出租车数据")
    public ResponseData getTaxi() {
        QueryWrapper<TravelSharing> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","3");
        return OK(travelSharingService.list(queryWrapper));
    }
}
