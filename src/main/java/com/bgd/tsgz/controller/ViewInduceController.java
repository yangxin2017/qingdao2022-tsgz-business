package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisDevice;
import com.bgd.tsgz.entity.ViewInduce;
import com.bgd.tsgz.service.BisDeviceService;
import com.bgd.tsgz.service.ViewInduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "诱导", tags = {"诱导"})
public class ViewInduceController {
    @Autowired
    private ViewInduceService viewInduceService;
    @Autowired
    private BisDeviceService bisDeviceService;

    @GetMapping("getInduceList")
    @ApiOperation(value = "获取诱导列表", notes = "获取诱导列表")
    public ResponseData<ViewInduce> getInduceList() {
//        QueryWrapper<ViewInduce> queryWrapper = new QueryWrapper<>();
//
//        return OK(viewInduceService.list(queryWrapper));
        JSONArray jsonArray = new JSONArray();

        QueryWrapper<BisDevice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("devicetype_id", "451");
        for (BisDevice bisDevice : bisDeviceService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("lng", bisDevice.getLongitude());
            jsonObject.put("lat", bisDevice.getLatitude());
            jsonObject.put("name", bisDevice.getDeviceName());
            jsonObject.put("department", bisDevice.getDeviceCode());
            jsonObject.put("address", bisDevice.getDevicePort());
            jsonObject.put("installDate", bisDevice.getInstallDate());
            jsonObject.put("thirdNumber", bisDevice.getThirdsyscode());
            jsonObject.put("status", bisDevice.getDeviceStatus());
            jsonObject.put("type", bisDevice.getModel());
            jsonObject.put("id", bisDevice.getDeviceCode());

            jsonArray.add(jsonObject);
        }

        return OK(jsonArray);
    }
}
