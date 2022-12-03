package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.CityClustersSurvey;
import com.bgd.tsgz.entity.ViewAcf;
import com.bgd.tsgz.service.AcdFileService;
import com.bgd.tsgz.service.CityClustersSurveyService;
import com.bgd.tsgz.service.ViewAcfService;
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
@Api(value = "城市群面板", tags = {"城市群面板"})
public class CityClustersSurveyController {
    @Autowired
    private CityClustersSurveyService cityClustersSurveyService;

//    @GetMapping("getAcdFileList")
//    @ApiOperation(value = "事故列表获取", notes = "事故列表获取")
//    public ResponseData<ViewAcf> getVideoPointList(String time) throws ParseException {
//    }
    // 城市群概况
    @GetMapping("getCityClustersSurvey")
    @ApiOperation(value = "城市群概况", notes = "城市群概况")
    public ResponseData getCityClustersSurvey() {
        QueryWrapper<CityClustersSurvey> queryWrapper = new QueryWrapper<>();
        return OK(cityClustersSurveyService.list(queryWrapper));
    }
}
