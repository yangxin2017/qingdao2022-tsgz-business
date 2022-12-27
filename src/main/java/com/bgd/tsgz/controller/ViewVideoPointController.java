package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisDevice;
import com.bgd.tsgz.entity.ViewVideoPoint;
import com.bgd.tsgz.service.BisDeviceService;
import com.bgd.tsgz.service.ViewVideoPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "视频点位", tags = {"视频点位"})
public class ViewVideoPointController {
    @Autowired
    private ViewVideoPointService viewVideoPointService;
    @Autowired
    private BisDeviceService bisDeviceService;

    @GetMapping("getVideoPointList")
    @ApiOperation(value = "获取视频点位列表", notes = "获取视频点位列表")
    @RequestLog(moduleName = "视频点位",functionName = "获取视频点位列表")
    public ResponseData<ViewVideoPoint> getVideoPointList() {
//        QueryWrapper<ViewVideoPoint> queryWrapper = new QueryWrapper<>();
//
//        return OK(viewVideoPointService.list(queryWrapper));
        JSONArray jsonArray = new JSONArray();

        QueryWrapper<BisDevice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("devicetype_id", "021");
        for (BisDevice bisDevice : bisDeviceService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("lng", bisDevice.getLongitude());
            jsonObject.put("lat", bisDevice.getLatitude());
            jsonObject.put("name", bisDevice.getDeviceName());
            jsonObject.put("model", bisDevice.getModel());
            jsonObject.put("department", bisDevice.getDeviceCode());
            jsonObject.put("address", bisDevice.getDevicePort());
            jsonObject.put("installDate", bisDevice.getInstallDate());
            jsonObject.put("videoNo", bisDevice.getDeviceCode());
            jsonObject.put("status", bisDevice.getDeviceStatus());
            jsonObject.put("id", bisDevice.getDeviceCode());

            jsonArray.add(jsonObject);
        }

        return OK(jsonArray);

//        return OK(jsonArray);
    }
}
