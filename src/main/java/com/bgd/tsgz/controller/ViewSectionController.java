package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public ResponseData<ViewSection> getSectionList(String name) {
//        QueryWrapper<ViewSection> queryWrapper = new QueryWrapper<>();
//        if(name != null && !name.equals("")){
//            queryWrapper.like("name", name);
//        }
//
//        JSONArray jsonArray = new JSONArray();
//        // gis为jsonarray字符串，转换为jsonarray
//        for(ViewSection viewSection : viewSectionService.list(queryWrapper)){
//            JSONObject json = new JSONObject();
//            JSONArray gis = JSONArray.parseArray(viewSection.getGis());
//            json.put("id", viewSection.getId());
//            json.put("name", viewSection.getName());
//            json.put("threshold", viewSection.getThreshold());
//            json.put("gis", gis);
//            json.put("type", viewSection.getType());
//            jsonArray.add(json);
//        }
//
//        return OK(jsonArray);
        String[] codeList = "3702032077512411,3702032077510686,3702032075514215,3702032075513957,3702022077214221,3702022077213962,3702022073213962,3702001421420775,3702001396320772,3702001396220772,3702001396120732,3702001395820755,3702001395720755,3702001068620775,3702852068711596,3702852068711593,3702031549910323,3702031032313956,3702021554213195,3702021319515542,3702001554213963,3702001551913959,3702001549910786,3702001422113963,3702001422013961,3702001421914220,3702001421814219,3702001421714218,3702001421614217,3702001421514216,3702001396315542,3702001396213961,3702001396115519,3702001395913958,3702001395713956,3702001395613846,3702001395610686,3702001395514214,3702001384613957,3702001241212409,3702001241113955,3702001241112410,3702001241012409,3702001240914214,3702001240912412,3702001132110786,3702001132110686,3702001068613956,3702001032315499,3702852068711625,3702852068711623,3702022076515742,3702022076514582,3702001574220765,3702001458420765,3702031372811834,3702001372913728,3702001372813727,3702832043910982,3702001438014379,3702001438010982,3702001437914380,3702001434512721,3702001434512643,3702001272114345,3702001264314345,3702001098320439,3702001098312643,3702001098214380,3702001098210983,3702831820614800,3702001480018206,3702021107220249,3702032073613023,3702032073613022,3702001302320736,3702001302220736,3702031172213016,3702021303815500,3702001585513017,3702001585511486,3702001550013039,3702001550013038,3702001549313027,3702001549313026,3702001548313025,3702001548313024,3702001303915500,3702001303813037,3702001303713038,3702001303713027,3702001302715493,3702001302713037,3702001302615493,3702001302613025,3702001302515483,3702001302513026,3702001302415483,3702001302413023,3702001302313024,3702001302213021,3702001302113022,3702001301812159,3702001301715855,3702001301711722,3702001301611722,3702001215913018,3702001215911486,3702001172213017,3702001148615855,3702001148612159,3702001098010981,3702001098010979,3702001097910980,3702001097910978,3702001097810979,3702001097810297,3702001097710976,3702001097710297,3702001097610977,3702001097610975,3702001097510976,3702001029710978,3702001029710977".split(",");

        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("section_code", codeList);
        JSONArray jsonArray = new JSONArray();
        for(BisSection bisSection : bisSectionService.list(queryWrapper)){
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
            jsonArray.add(json);
        }
        return OK(jsonArray);

    }
}
