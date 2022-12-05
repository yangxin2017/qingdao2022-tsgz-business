package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.IntercityTravel;
import com.bgd.tsgz.service.IntercityTravelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "城际出行", tags = {"城际出行"})
public class IntercityTravelController {
    @Autowired
    private IntercityTravelService intercityTravelService;

    @GetMapping("getIntercityHighSpeedRailList")
    @ApiOperation(value = "获取城际高铁列表", notes = "获取城际高铁列表")
    public ResponseData getIntercityHighSpeedRailList() {
        return OK(intercityTravelService.getTravelList("1"));
    }

    @GetMapping("getIntercityPassengerCarList")
    @ApiOperation(value = "获取城际客车列表", notes = "获取城际客车列表")
    public ResponseData getIntercityPassengerCarList() {
        return OK(intercityTravelService.getTravelList("2"));
    }

    @GetMapping("getIntercityShipList")
    @ApiOperation(value = "获取城际船舶列表", notes = "获取城际船舶列表")
    public ResponseData getIntercityShipList() {
        return OK(intercityTravelService.getTravelList("3"));
    }

    @GetMapping("getIntercityAviationList")
    @ApiOperation(value = "获取城际航空列表", notes = "获取城际航空列表")
    public ResponseData getIntercityAviationList() {
        return OK(intercityTravelService.getTravelList("4"));
    }

    @GetMapping("getIntercityPrivateCarList")
    @ApiOperation(value = "获取城际私家车列表", notes = "获取城际私家车列表")
    public ResponseData getIntercityPrivateCarList() {
        return OK(intercityTravelService.getTravelList("5"));
    }
}
