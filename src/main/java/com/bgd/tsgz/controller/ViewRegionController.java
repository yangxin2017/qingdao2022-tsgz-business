package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewRegion;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.ViewRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点区域", tags = {"重点区域"})
public class ViewRegionController {
    @Autowired
    private ViewRegionService viewRegionService;

    @GetMapping("getRegionList")
    @ApiOperation(value = "获取重点区域列表", notes = "获取重点区域列表")
    public ResponseData<ViewRegion> getRegionList(String name) {
        QueryWrapper<ViewRegion> queryWrapper = new QueryWrapper<>();
        if(name != null && !name.equals("")){
            queryWrapper.like("name", name);
        }
        JSONArray jsonArray = new JSONArray();
        // gis为jsonarray字符串，转换为jsonarray
        for(ViewRegion viewRegion : viewRegionService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewRegion.getGis());
            json.put("id", viewRegion.getId());
            json.put("name", viewRegion.getName());
            json.put("threshold", viewRegion.getThreshold());
            json.put("gis", gis);
            jsonArray.add(json);
        }
        return OK(jsonArray);
    }
}
