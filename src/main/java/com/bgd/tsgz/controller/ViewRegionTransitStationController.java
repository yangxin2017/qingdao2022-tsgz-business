package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewRegionTransitStation;
import com.bgd.tsgz.service.ViewRegionTransitStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "公交站点", tags = {"公交站点"})
public class ViewRegionTransitStationController {
    @Autowired
    private ViewRegionTransitStationService viewRegionTransitStationService;

    @GetMapping("getRegionTransitStationList")
    @ApiOperation(value = "获取公交站点列表", notes = "获取公交站点列表")
    public ResponseData<ViewRegionTransitStation> getRegionTransitStationList() {
        QueryWrapper<ViewRegionTransitStation> queryWrapper = new QueryWrapper<>();

        return OK(viewRegionTransitStationService.list(queryWrapper));
    }
}
