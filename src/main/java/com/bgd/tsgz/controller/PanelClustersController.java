package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.CityClustersContact;
import com.bgd.tsgz.entity.CityClustersEvaluate;
import com.bgd.tsgz.entity.CityClustersFeatures;
import com.bgd.tsgz.entity.CityClustersSurvey;
import com.bgd.tsgz.service.CityClustersContactService;
import com.bgd.tsgz.service.CityClustersEvaluateService;
import com.bgd.tsgz.service.CityClustersFeaturesService;
import com.bgd.tsgz.service.CityClustersSurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "面板数据-城市群", tags = {"面板数据-城市群"})
public class PanelClustersController {
    @Autowired
    private CityClustersFeaturesService cityClustersFeaturesService;
    @Autowired
    private CityClustersContactService cityClustersContactService;
    @Autowired
    private CityClustersSurveyService cityClustersSurveyService;
    @Autowired
    private CityClustersEvaluateService cityClustersEvaluateService;

    // 城市群节点特征交通活力值排名
    @GetMapping("getVitalityList")
    @ApiOperation(value = "获取交通活力值排名", notes = "获取交通活力值排名")
    public Object getClustersVitality() {
        QueryWrapper<CityClustersFeatures> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("vitality");
        JSONArray jsonArray = new JSONArray();
        cityClustersFeaturesService.list(queryWrapper).forEach(cityClustersFeatures -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", cityClustersFeatures.getName());
            jsonObject.put("value", cityClustersFeatures.getVitality());
            jsonArray.add(jsonObject);
        });
        return OK(jsonArray);
    }

    // 城市群节点特征交通规模值排名
    @GetMapping("getScaleList")
    @ApiOperation(value = "获取交通规模值排名", notes = "获取交通规模值排名")
    public Object getClustersScale() {
        QueryWrapper<CityClustersFeatures> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("scale");
        JSONArray jsonArray = new JSONArray();
        cityClustersFeaturesService.list(queryWrapper).forEach(cityClustersFeatures -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", cityClustersFeatures.getName());
            jsonObject.put("value", cityClustersFeatures.getScale());
            jsonArray.add(jsonObject);
        });
        return OK(jsonArray);
    }

    // 城市群节点特征交通中心性值排名
    @GetMapping("getCentralityList")
    @ApiOperation(value = "获取交通中心性值排名", notes = "获取交通中心性值排名")
    public Object getClustersCentrality() {
        QueryWrapper<CityClustersFeatures> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("centrality");
        JSONArray jsonArray = new JSONArray();
        cityClustersFeaturesService.list(queryWrapper).forEach(cityClustersFeatures -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", cityClustersFeatures.getName());
            jsonObject.put("value", cityClustersFeatures.getCentrality());
            jsonArray.add(jsonObject);
        });
        return OK(jsonArray);
    }

    // 城市群城市联系特征分析
    @GetMapping("getContactList")
    @ApiOperation(value = "获取城市联系特征分析", notes = "获取城市联系特征分析")
    public Object getClustersContact() {
        QueryWrapper<CityClustersContact> queryWrapper = new QueryWrapper<>();
        return OK(cityClustersContactService.list(queryWrapper));
    }

    // 城市群概况
    @GetMapping("getCityClustersSurvey")
    @ApiOperation(value = "城市群概况", notes = "城市群概况")
    public ResponseData getCityClustersSurvey() {
        QueryWrapper<CityClustersSurvey> queryWrapper = new QueryWrapper<>();
        return OK(cityClustersSurveyService.list(queryWrapper));
    }

    // 城市群综合评分
    @GetMapping("getCityClustersEvaluate")
    @ApiOperation(value = "城市群综合评分", notes = "城市群综合评分")
    public ResponseData getCityClustersEvaluate() {
        QueryWrapper<CityClustersEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","1");
        return OK(cityClustersEvaluateService.list(queryWrapper));
    }

    // 城市群综合评价
    @GetMapping("getCityClustersEvaluateList")
    @ApiOperation(value = "城市群综合评价", notes = "城市群综合评价")
    public ResponseData getCityClustersEvaluateList() {
        QueryWrapper<CityClustersEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","2");
        return OK(cityClustersEvaluateService.list(queryWrapper));
    }

    // 城市群安全评分
    @GetMapping("getCityClustersEvaluateSafe")
    @ApiOperation(value = "城市群安全评分", notes = "城市群安全评分")
    public ResponseData getCityClustersEvaluateSafe() {
        QueryWrapper<CityClustersEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","3");
        return OK(cityClustersEvaluateService.list(queryWrapper));
    }

    // 高效
    @GetMapping("getCityClustersEvaluateEfficient")
    @ApiOperation(value = "城市群高效评分", notes = "城市群高效评分")
    public ResponseData getCityClustersEvaluateEfficient() {
        QueryWrapper<CityClustersEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","4");
        return OK(cityClustersEvaluateService.list(queryWrapper));
    }

    // 便捷
    @GetMapping("getCityClustersEvaluateConvenient")
    @ApiOperation(value = "城市群便捷评分", notes = "城市群便捷评分")
    public ResponseData getCityClustersEvaluateConvenient() {
        QueryWrapper<CityClustersEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","5");
        return OK(cityClustersEvaluateService.list(queryWrapper));
    }
}
