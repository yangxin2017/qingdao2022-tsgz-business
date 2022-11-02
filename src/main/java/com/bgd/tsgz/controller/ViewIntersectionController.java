package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewIntersection;
import com.bgd.tsgz.service.ViewIntersectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点路口", tags = {"重点路口"})
public class ViewIntersectionController {
    @Autowired
    private ViewIntersectionService viewIntersectionService;

    @GetMapping("getIntersectionList")
    @ApiOperation(value = "获取重点路口列表", notes = "获取重点路口列表")
    public ResponseData<ViewIntersection> getIntersectionList(String name) {
        QueryWrapper<ViewIntersection> queryWrapper = new QueryWrapper<>();
        if(name != null && !name.equals("")){
            queryWrapper.like("name", name);
        }
        return OK(viewIntersectionService.list(queryWrapper));
    }
}
