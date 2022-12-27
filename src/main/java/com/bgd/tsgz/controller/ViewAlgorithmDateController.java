package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewAlgorithmDate;
import com.bgd.tsgz.service.ViewAlgorithmDateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.ERROR;
import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "算法中存在数据的日期", tags = {"算法中存在数据的日期"})
public class ViewAlgorithmDateController {
    @Autowired
    private ViewAlgorithmDateService viewAlgorithmDateService;

    @GetMapping("getAlgorithmDateList")
    @ApiOperation(value = "获取算法中存在数据的日期列表", notes = "获取算法中存在数据的日期列表")
    @RequestLog(moduleName = "预测算法",functionName = "获取算法中存在数据的日期列表")
    public ResponseData<ViewAlgorithmDate> getAlgorithmDateList(Integer aid) {
        QueryWrapper<ViewAlgorithmDate> queryWrapper = new QueryWrapper<>();
        if(aid != null) {
            queryWrapper.eq("aid", aid);
        }else{
            return ERROR(101,"aid不能为空");
        }

        return OK(viewAlgorithmDateService.list(queryWrapper));
    }
}
