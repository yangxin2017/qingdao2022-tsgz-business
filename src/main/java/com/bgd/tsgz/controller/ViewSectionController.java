package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.ViewSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点路段", tags = {"重点路段"})
public class ViewSectionController {
    @Autowired
    private ViewSectionService viewSectionService;

    @GetMapping("getSectionList")
    @ApiOperation(value = "获取重点路段列表", notes = "获取重点路段列表")
    public ResponseData<ViewSection> getSectionList(String name) {
        QueryWrapper<ViewSection> queryWrapper = new QueryWrapper<>();
        if(name != null && !name.equals("")){
            queryWrapper.like("name", name);
        }

        JSONArray jsonArray = new JSONArray();
        // gis为jsonarray字符串，转换为jsonarray
        for(ViewSection viewSection : viewSectionService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewSection.getGis());
            json.put("id", viewSection.getId());
            json.put("name", viewSection.getName());
            json.put("threshold", viewSection.getThreshold());
            json.put("gis", gis);
            json.put("type", viewSection.getType());
            jsonArray.add(json);
        }

        return OK(jsonArray);
    }
}
