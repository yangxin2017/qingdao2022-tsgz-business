package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewVideoPoint;
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

    @GetMapping("getVideoPointList")
    @ApiOperation(value = "获取视频点位列表", notes = "获取视频点位列表")
    public ResponseData<ViewVideoPoint> getVideoPointList() {
        QueryWrapper<ViewVideoPoint> queryWrapper = new QueryWrapper<>();

        return OK(viewVideoPointService.list(queryWrapper));
    }
}
