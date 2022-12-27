package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewAlgorithm;
import com.bgd.tsgz.service.ViewAlgorithmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "预测算法", tags = {"预测算法"})
public class ViewAlgorithmController {
    @Autowired
    private ViewAlgorithmService viewAlgorithmService;

    @GetMapping("getAlgorithmList")
    @ApiOperation(value = "获取预测算法列表", notes = "获取预测算法列表")
    @RequestLog(moduleName = "预测算法",functionName = "获取预测算法列表")
    public ResponseData<ViewAlgorithm> getAlgorithmList() {
        QueryWrapper<ViewAlgorithm> queryWrapper = new QueryWrapper<>();

        return OK(viewAlgorithmService.list(queryWrapper));
    }
}
