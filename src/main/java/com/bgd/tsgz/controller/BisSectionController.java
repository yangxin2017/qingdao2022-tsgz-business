package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.service.BisSectionService;
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
@Api(value = "测试", tags = {"测试"})
public class BisSectionController {
    @Autowired
    private BisSectionService BisSectionService;

    @GetMapping("getBisSectionList")
    @ApiOperation(value = "测试获取", notes = "测试获取")
    public ResponseData<BisSection> getVideoPointList() {
        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("section_code", "3702001013710136");

        List list = BisSectionService.list(queryWrapper);

        return OK(BisSectionService.list(queryWrapper));
    }
}
