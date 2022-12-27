package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.BisSectionService;
import com.bgd.tsgz.service.ViewSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点路段", tags = {"重点路段"})
public class ViewSectionController {
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private BisSectionService bisSectionService;

    @GetMapping("getSectionList")
    @ApiOperation(value = "获取重点路段列表", notes = "获取重点路段列表")
    @RequestLog(moduleName = "重点路段",functionName = "获取重点路段列表")
    public ResponseData<ViewSection> getSectionList(String name , String areaCode) {
        QueryWrapper<ViewSection> viewSectionWrapper = new QueryWrapper<>();
        ArrayList<String> codeList = new ArrayList<>();
        // 将viewSectionWrapper所有的code值放入一个数组中
        for (ViewSection viewSection : viewSectionService.list(viewSectionWrapper)) {
            codeList.add(viewSection.getCode());
        }

        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("section_code", codeList);
        if (name != null) {
            queryWrapper.like("section_name", name);
        }
        if (areaCode != null) {
            queryWrapper.eq("area_code", areaCode);
        }
        JSONArray jsonArray = new JSONArray();
        for(BisSection bisSection : bisSectionService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            json.put("id", bisSection.getSectionCode());
            json.put("name", bisSection.getSectionName());
            JSONArray position = new JSONArray();
            // 将position以逗号分割，单位数为lng，双位数为lat，两个一组存入position
            String[] positionArray = bisSection.getPosition().split(",");
            for(int j = 0; j < positionArray.length-1; j+=2){
                JSONObject positionItem = new JSONObject();
                positionItem.put("lng", positionArray[j]);
                positionItem.put("lat", positionArray[j+1]);
                position.add(positionItem);
            }
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
