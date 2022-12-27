package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewRegionPedestrianHeal;
import com.bgd.tsgz.service.ViewRegionPedestrianHealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "行人分布", tags = {"行人分布"})
public class ViewRegionPedestrianHealController {
    @Autowired
    private ViewRegionPedestrianHealService viewRegionPedestrianHealService;

    @GetMapping("getRegionPedestrianHealList")
    @ApiOperation(value = "获取行人分布热力列表", notes = "获取行人分布热力列表")
    @RequestLog(moduleName = "行人分布",functionName = "获取行人分布热力列表")
    public ResponseData<ViewRegionPedestrianHeal> getRegionPedestrianHealList() {
        QueryWrapper<ViewRegionPedestrianHeal> queryWrapper = new QueryWrapper<>();

        return OK(viewRegionPedestrianHealService.list(queryWrapper));
    }
}
