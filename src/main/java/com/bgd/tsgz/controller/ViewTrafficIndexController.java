package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewTrafficIndex;
import com.bgd.tsgz.entity.ViewTrafficParking;
import com.bgd.tsgz.entity.ViewTrafficRegion;
import com.bgd.tsgz.entity.ViewTrafficSection;
import com.bgd.tsgz.service.ViewTrafficIndexService;
import com.bgd.tsgz.service.ViewTrafficParkingService;
import com.bgd.tsgz.service.ViewTrafficRegionService;
import com.bgd.tsgz.service.ViewTrafficSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "交通运行", tags = {"交通运行"})
public class ViewTrafficIndexController {
    @Autowired
    private ViewTrafficIndexService viewTrafficIndexService;
    @Autowired
    private ViewTrafficParkingService viewTrafficParkingService;
    @Autowired
    private ViewTrafficRegionService viewTrafficRegionService;
    @Autowired
    private ViewTrafficSectionService viewTrafficSectionService;

    @GetMapping("getTrafficIndexList")
    @ApiOperation(value = "获取指数列表", notes = "获取指数列表")
    @RequestLog(moduleName = "交通运行",functionName = "获取指数列表")
    public ResponseData<ViewTrafficIndex> getTrafficIndexList() {
        QueryWrapper<ViewTrafficIndex> queryWrapper = new QueryWrapper<>();

        return OK(viewTrafficIndexService.list(queryWrapper));
    }

    @GetMapping("getTrafficParkingList")
    @ApiOperation(value = "获取停车场位数量", notes = "获取停车场位数量")
    @RequestLog(moduleName = "交通运行",functionName = "获取停车场位数量")
    public ResponseData<ViewTrafficParking> getTrafficParkingList() {
        QueryWrapper<ViewTrafficParking> queryWrapper = new QueryWrapper<>();

        Integer total = 0;
        Integer free = 0;
        Integer stopped = 0;

        List<ViewTrafficParking> list = viewTrafficParkingService.list(queryWrapper);
        for(ViewTrafficParking viewTrafficParking : list){
            total += viewTrafficParking.getTotal();
            free += viewTrafficParking.getFree();
            stopped += viewTrafficParking.getStopped();
        }

        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("free", free);
        json.put("stopped", stopped);
        if(total != 0){
            json.put("rate", stopped * 100 / total + "%");
        }else{
            json.put("rate", 0);
        }

        return OK(json);
    }

    @GetMapping("getTrafficRegionList")
    @ApiOperation(value = "获取区域列表", notes = "获取区域列表")
    @RequestLog(moduleName = "交通运行",functionName = "获取区域列表")
    public ResponseData<ViewTrafficRegion>  getTrafficRegionList() {
        QueryWrapper<ViewTrafficRegion> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("value");
        queryWrapper.last("limit 5");

        return OK(viewTrafficRegionService.list(queryWrapper));
    }

    @GetMapping("getTrafficSectionList")
    @ApiOperation(value = "获取道路列表", notes = "获取道路列表")
    @RequestLog(moduleName = "交通运行",functionName = "获取道路列表")
    public ResponseData<ViewTrafficSection>  getTrafficSectionList() {
        QueryWrapper<ViewTrafficSection> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("value");
        queryWrapper.last("limit 5");

        return OK(viewTrafficSectionService.list(queryWrapper));
    }
}
