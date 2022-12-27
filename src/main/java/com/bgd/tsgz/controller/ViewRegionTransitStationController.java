package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.Mcstationinfogs;
import com.bgd.tsgz.entity.ViewRegionTransitStation;
import com.bgd.tsgz.service.McstationinfogsService;
import com.bgd.tsgz.service.ViewRegionTransitStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "公交站点", tags = {"公交站点"})
public class ViewRegionTransitStationController {
    @Autowired
    private ViewRegionTransitStationService viewRegionTransitStationService;
    @Autowired
    private McstationinfogsService mcstationinfogsService;

    @GetMapping("getRegionTransitStationList")
    @ApiOperation(value = "获取公交站点列表", notes = "获取公交站点列表")
    @RequestLog(moduleName = "公交站点",functionName = "获取公交站点列表")
    public ResponseData<ViewRegionTransitStation> getRegionTransitStationList() {
//        QueryWrapper<ViewRegionTransitStation> queryWrapper = new QueryWrapper<>();
//
//        return OK(viewRegionTransitStationService.list(queryWrapper));
        QueryWrapper<Mcstationinfogs> queryWrapper = new QueryWrapper<>();

        ArrayList retlist = new ArrayList();

        // 循环mcstationinfogsService.list(queryWrapper)
        for (Mcstationinfogs mcstationinfogs : mcstationinfogsService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", mcstationinfogs.getStationid());
            jsonObject.put("name", mcstationinfogs.getStationname());
            jsonObject.put("lng", mcstationinfogs.getLongitude());
            jsonObject.put("lat", mcstationinfogs.getLatitude());
            retlist.add(jsonObject);
        }
        return OK(retlist);
    }
}
