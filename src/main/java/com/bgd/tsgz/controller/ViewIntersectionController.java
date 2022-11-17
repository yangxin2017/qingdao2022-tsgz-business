package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisCrossing;
import com.bgd.tsgz.entity.ViewIntersection;
import com.bgd.tsgz.service.BisCrossingService;
import com.bgd.tsgz.service.ViewIntersectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点路口", tags = {"重点路口"})
public class ViewIntersectionController {
    @Autowired
    private ViewIntersectionService viewIntersectionService;
    @Autowired
    private BisCrossingService bisCrossingService;

    @GetMapping("getIntersectionList")
    @ApiOperation(value = "获取重点路口列表", notes = "获取重点路口列表")
    public ResponseData<ViewIntersection> getIntersectionList(String name) {
//        QueryWrapper<ViewIntersection> queryWrapper = new QueryWrapper<>();
//        if(name != null && !name.equals("")){
//            queryWrapper.like("name", name);
//        }
//        return OK(viewIntersectionService.list(queryWrapper));
        QueryWrapper<BisCrossing> queryWrapper = new QueryWrapper<>();
        ArrayList namelist = new ArrayList();
        namelist.add("香港西路与延安三路路口");
        namelist.add("香港路与山东路路口");
        namelist.add("香港中路与新浦路路口");
        namelist.add("香港路与南京路路口");
        namelist.add("香港路与福州路路口");
        namelist.add("香港中路与燕儿岛路路口");
        namelist.add("东海路与延安三路路口");
        namelist.add("东海路与山东路路口");
        namelist.add("东海西路与新浦路路口");
        namelist.add("东海西路与南京路路口");
        namelist.add("东海路与福州路路口");
        namelist.add("东海路与燕儿岛路路口");

        queryWrapper.in("crossing_name", namelist);

//        if(name != null && !name.equals("")){
//            queryWrapper.like("crossing_name", name);
//        }
        JSONArray jsonArray = new JSONArray();
        for (BisCrossing bisCrossing : bisCrossingService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", bisCrossing.getCrossingCode());
            jsonObject.put("name", bisCrossing.getCrossingName());
            jsonObject.put("lng", bisCrossing.getLongitude());
            jsonObject.put("lat", bisCrossing.getLatitude());
            jsonArray.add(jsonObject);
        }
        return OK(jsonArray);
    }
}
