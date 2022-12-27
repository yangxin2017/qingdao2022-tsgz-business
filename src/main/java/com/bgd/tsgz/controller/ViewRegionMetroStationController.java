package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.PoiSubway;
import com.bgd.tsgz.entity.ViewRegionMetroStation;
import com.bgd.tsgz.service.PoiSubwayService;
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
    @Autowired
    private PoiSubwayService poiSubwayService;

    @GetMapping("getRegionMetroStationList")
    @ApiOperation(value = "获取地铁站点列表", notes = "获取地铁站点列表")
    @RequestLog(moduleName = "地铁站点",functionName = "获取地铁站点列表")
    public ResponseData getRegionMetroStationList() {
//        QueryWrapper<ViewRegionMetroStation> queryWrapper = new QueryWrapper<>();
//
//        return OK(viewRegionMetroStationService.list(queryWrapper));
        QueryWrapper<PoiSubway> queryWrapper = new QueryWrapper<>();
        JSONArray jsonArray = new JSONArray();
        for(PoiSubway poiSubway : poiSubwayService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            json.put("id", poiSubway.getPid());
            json.put("name", poiSubway.getName());
            json.put("lng", poiSubway.getDisplayX());
            json.put("lat", poiSubway.getDisplayY());
            json.put("type",poiSubway.getType());

            jsonArray.add(json);
        }

        return OK(jsonArray);
    }
}
