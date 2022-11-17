package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisArea;
import com.bgd.tsgz.entity.ViewRegion;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.BisAreaService;
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
    @Autowired
    private BisAreaService bisAreaService;

    @GetMapping("getRegionList")
    @ApiOperation(value = "获取重点区域列表", notes = "获取重点区域列表")
    public ResponseData<ViewRegion> getRegionList(String name) {
//        QueryWrapper<ViewRegion> queryWrapper = new QueryWrapper<>();
//        if(name != null && !name.equals("")){
//            queryWrapper.like("name", name);
//        }
//        JSONArray jsonArray = new JSONArray();
//        // gis为jsonarray字符串，转换为jsonarray
//        for(ViewRegion viewRegion : viewRegionService.list(queryWrapper)){
//            JSONObject json = new JSONObject();
//            JSONArray gis = JSONArray.parseArray(viewRegion.getGis());
//            json.put("id", viewRegion.getId());
//            json.put("name", viewRegion.getName());
//            json.put("threshold", viewRegion.getThreshold());
//            json.put("gis", gis);
//            jsonArray.add(json);
//        }
//        return OK(jsonArray);
        QueryWrapper<BisArea> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_type", "02");
        if(name != null && !name.equals("")){
            queryWrapper.like("area_name", name);
        }
        JSONArray jsonArray = new JSONArray();
        for(BisArea bisArea : bisAreaService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            json.put("id", bisArea.getAreaCode());
            json.put("name", bisArea.getAreaName());
            json.put("threshold", 1);
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
        return OK(jsonArray);
    }
}
