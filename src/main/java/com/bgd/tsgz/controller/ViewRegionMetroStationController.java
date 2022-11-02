package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewRegionMetroStation;
import com.bgd.tsgz.service.ViewRegionMetroStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "地铁站点", tags = {"地铁站点"})
public class ViewRegionMetroStationController {
    @Autowired
    private ViewRegionMetroStationService viewRegionMetroStationService;

    @GetMapping("getRegionMetroStationList")
    @ApiOperation(value = "获取地铁站点列表", notes = "获取地铁站点列表")
    public ResponseData<ViewRegionMetroStation> getRegionMetroStationList() {
        QueryWrapper<ViewRegionMetroStation> queryWrapper = new QueryWrapper<>();

        return OK(viewRegionMetroStationService.list(queryWrapper));
    }
}
