package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewIntersection;
import com.bgd.tsgz.entity.ViewRegion;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.ViewIntersectionService;
import com.bgd.tsgz.service.ViewRegionService;
import com.bgd.tsgz.service.ViewSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "三合一搜索功能", tags = {"三合一搜索功能"})
public class ViewSearchRoadController {
    @Autowired
    private ViewIntersectionService viewIntersectionService;
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private ViewRegionService viewRegionService;

    @GetMapping("getSearchRoadList")
    @ApiOperation(value = "获取搜索列表", notes = "获取搜索列表")
    public ResponseData getSearchRoadList(String name) {
        // 从ViewIntersection、ViewSection、ViewRegion三个中搜索
        QueryWrapper<ViewIntersection> viewIntersectionQueryWrapper = new QueryWrapper();
        QueryWrapper<ViewSection> viewSectionQueryWrapper = new QueryWrapper();
        QueryWrapper<ViewRegion> viewRegionQueryWrapper = new QueryWrapper();
        if(name != null && !name.equals("")){
            viewIntersectionQueryWrapper.like("name", name);
            viewSectionQueryWrapper.like("name", name);
            viewRegionQueryWrapper.like("name", name);
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(viewIntersectionService.list(viewIntersectionQueryWrapper));

        JSONArray viewSectionArray = new JSONArray();
        for(ViewSection viewSection : viewSectionService.list(viewSectionQueryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewSection.getGis());
            json.put("id", viewSection.getId());
            json.put("name", viewSection.getName());
            json.put("threshold", viewSection.getThreshold());
            json.put("gis", gis);
            viewSectionArray.add(json);
        }
        jsonArray.addAll(viewSectionArray);

        JSONArray viewRegionArray = new JSONArray();
        for(ViewRegion viewRegion : viewRegionService.list(viewRegionQueryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewRegion.getGis());
            json.put("id", viewRegion.getId());
            json.put("name", viewRegion.getName());
            json.put("threshold", viewRegion.getThreshold());
            json.put("gis", gis);
            viewRegionArray.add(json);
        }
        jsonArray.addAll(viewRegionArray);
        return OK(jsonArray);

    }
}
