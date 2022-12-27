package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.*;
import com.bgd.tsgz.service.*;
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
@Api(value = "三合一搜索功能", tags = {"三合一搜索功能"})
public class ViewSearchRoadController {
    @Autowired
    private ViewIntersectionService viewIntersectionService;
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private ViewRegionService viewRegionService;
    @Autowired
    private BisCrossingService bisCrossingService;
    @Autowired
    private BisAreaService bisAreaService;
    @Autowired
    private BisSectionService bisSectionService;

    @GetMapping("getSearchRoadList")
    @ApiOperation(value = "获取搜索列表", notes = "获取搜索列表")
    @RequestLog(moduleName = "三合一搜索功能",functionName = "获取搜索列表")
    public ResponseData getSearchRoadList(String name) {
        if(name == null || name.equals("")){
            name = "";
        }
        JSONArray jsonArray = new JSONArray();

        // 路口
        QueryWrapper<ViewIntersection> viewIntersectionWrapper = new QueryWrapper<>();
        ArrayList<String> codeList = new ArrayList<>();
        // 将viewSectionWrapper所有的code值放入一个数组中
        for (ViewIntersection viewIntersection : viewIntersectionService.list(viewIntersectionWrapper)) {
            codeList.add(viewIntersection.getCode());
        }

        QueryWrapper<BisCrossing> queryWrapper = new QueryWrapper<>();

        queryWrapper.in("crossing_code", codeList);
        if (name != null) {
            queryWrapper.like("crossing_name", name);
        }


        for (BisCrossing bisCrossing : bisCrossingService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", bisCrossing.getCrossingCode());
            jsonObject.put("name", bisCrossing.getCrossingName());
            jsonObject.put("lng", bisCrossing.getLongitude());
            jsonObject.put("lat", bisCrossing.getLatitude());
            jsonObject.put("typeId", "1");
            jsonArray.add(jsonObject);
        }


        // 区域
        QueryWrapper<BisArea> queryWrapperArea = new QueryWrapper<>();
        queryWrapperArea.eq("area_type", "02");
        queryWrapperArea.like("area_name", name);
        if(name != null){
            queryWrapperArea.like("area_name", name);
        }
        for(BisArea bisArea : bisAreaService.list(queryWrapperArea)){
            JSONObject json = new JSONObject();
            json.put("id", bisArea.getAreaCode());
            json.put("name", bisArea.getAreaName());
            json.put("threshold", 1);
            json.put("typeId", "3");
            JSONArray position = new JSONArray();
            // 将position以逗号分割，单位数为lng，双位数为lat，两个一组存入position
            String[] positionArray = bisArea.getCoordinate().split(",");
            for(int j = 0; j < positionArray.length-1; j+=2){
                JSONObject positionItem = new JSONObject();
                positionItem.put("lng", positionArray[j]);
                positionItem.put("lat", positionArray[j+1]);
                position.add(positionItem);
            }
            json.put("gis",position);
            jsonArray.add(json);
        }


        QueryWrapper<ViewSection> viewSectionWrapper = new QueryWrapper<>();
        codeList = new ArrayList<>();
        // 将viewSectionWrapper所有的code值放入一个数组中
        for (ViewSection viewSection : viewSectionService.list(viewSectionWrapper)) {
            codeList.add(viewSection.getCode());
        }

        QueryWrapper<BisSection> queryWrapperSection = new QueryWrapper<>();
        queryWrapperSection.in("section_code", codeList);
        if (name != null) {
            queryWrapperSection.like("section_name", name);
        }
        for(BisSection bisSection : bisSectionService.list(queryWrapperSection)){
            JSONObject json = new JSONObject();
            JSONArray position = new JSONArray();
            // 将position以逗号分割，单位数为lng，双位数为lat，两个一组存入position
            String[] positionArray = bisSection.getPosition().split(",");
            for(int j = 0; j < positionArray.length-1; j+=2){
                JSONObject positionItem = new JSONObject();
                positionItem.put("lng", positionArray[j]);
                positionItem.put("lat", positionArray[j+1]);
                position.add(positionItem);
            }
            json.put("id", bisSection.getSectionCode());
            json.put("name", bisSection.getSectionName());
            json.put("gis", position);
            json.put("typeId", "2");
//            jsonArray.add(json);

            for(int j = 0; j < position.size()-1; j++){
                JSONArray line = new JSONArray();
                JSONObject positionItem = position.getJSONObject(j);
                JSONObject positionItemNext = position.getJSONObject(j+1);
                line.add(positionItem);
                line.add(positionItemNext);
                json.put("gis", line);
                jsonArray.add(json);
            }
        }

        return OK(jsonArray);

    }
}
