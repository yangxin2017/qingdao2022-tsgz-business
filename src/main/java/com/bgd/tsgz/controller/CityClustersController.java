package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.entity.CityClustersContact;
import com.bgd.tsgz.service.CityClustersContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "出行联系", tags = {"出行联系"})
public class CityClustersController {
    @Autowired
    private CityClustersContactService cityClustersContactService;


    // getTravelContactList
    // 获取出行联系列表
    @GetMapping("getTravelContactList")
    @ApiOperation(value = "地图出行联系", notes = "地图出行联系")
    public Object getTravelContactList() {
        QueryWrapper<CityClustersContact> queryWrapper = new QueryWrapper();
        JSONArray result = new JSONArray();
        for (CityClustersContact cityClustersContact : cityClustersContactService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", cityClustersContact.getFlow());
            JSONArray gis = new JSONArray();
            JSONObject setgis = new JSONObject();
            setgis.put("name", cityClustersContact.getName());
            setgis.put("lng", cityClustersContact.getSposition().split(",")[0]);
            setgis.put("lat", cityClustersContact.getSposition().split(",")[1]);
            gis.add(setgis);
            setgis = new JSONObject();
            setgis.put("name", cityClustersContact.getFirst());
            setgis.put("lng", cityClustersContact.getEposition().split(",")[0]);
            setgis.put("lat", cityClustersContact.getEposition().split(",")[1]);
            gis.add(setgis);
            jsonObject.put("gis", gis);
            jsonObject.put("id", cityClustersContact.getId());
            result.add(jsonObject);
        }
        return OK(result);
    }
}
