package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewDistribute;
import com.bgd.tsgz.service.ViewDistributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "职住分布", tags = {"职住分布"})
public class ViewDistributeController {
    @Autowired
    private ViewDistributeService viewDistributeService;

    @GetMapping("getDistributeList")
    @ApiOperation(value = "获取职住分布列表", notes = "获取职住分布列表")
    public ResponseData<ViewDistribute> getDistributeList() {
        QueryWrapper<ViewDistribute> queryWrapper = new QueryWrapper<>();

        return OK(viewDistributeService.list(queryWrapper));
    }
}
