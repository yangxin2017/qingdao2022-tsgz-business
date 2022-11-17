package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.service.PanelCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "面板数据-城市级", tags = {"面板数据-城市级"})
public class PanelCityController {

    @Autowired
    private PanelCityService panelCityService;


    @GetMapping("getTpiList")
    @ApiOperation(value = "交通指数/拥堵指数", notes = "交通指数/拥堵指数")
    public ResponseData<AcdFile> getTpiList(){
        JSONObject result = panelCityService.getTpiList();
        return OK(result);
    }

    @GetMapping("getTpi24List")
    @ApiOperation(value = "交通指数/拥堵指数24小时", notes = "交通指数/拥堵指数24小时")
    public ResponseData<AcdFile> getTpi24List(){
        JSONObject result = panelCityService.getTpi24List();
        return OK(result);
    }

    @GetMapping("getAvgSpeedList")
    @ApiOperation(value = "平均速度", notes = "平均速度")
    public ResponseData<AcdFile> getAvgSpeedList(){
        JSONObject result = panelCityService.getAvgSpeedList();
        return OK(result);
    }

    @GetMapping("getTransitnumList")
    @ApiOperation(value = "在途车辆", notes = "在途车辆")
    public ResponseData<AcdFile> getTransitnumList(){
        JSONObject result = panelCityService.getTransitnumList();
        return OK(result);
    }

    @GetMapping("getCongestionRanking")
    @ApiOperation(value = "区域拥堵排名", notes = "区域拥堵排名")
    public ResponseData<AcdFile> getCongestionRanking(){
        JSONArray result = panelCityService.getCongestionRanking();
        return OK(result);
    }

    @GetMapping("getFocusAreaRanking")
    @ApiOperation(value = "重点区域拥堵排名", notes = "重点区域拥堵排名")
    public ResponseData<AcdFile> getFocusAreaRanking(){
        JSONArray result = panelCityService.getFocusAreaRanking();
        return OK(result);
    }

    @GetMapping("getRoadCongestionRanking")
    @ApiOperation(value = "路段拥堵排名", notes = "路段拥堵排名")
    public ResponseData<AcdFile> getRoadCongestionRanking(){
        JSONArray result = panelCityService.getRoadCongestionRanking();
        return OK(result);
    }

    @GetMapping("getHighwayCongestionRanking")
    @ApiOperation(value = "高速拥堵排名", notes = "高速拥堵排名")
    public ResponseData<AcdFile> getHighwayCongestionRanking(){
        JSONArray result = panelCityService.getHighwayCongestionRanking();
        return OK(result);
    }
}
