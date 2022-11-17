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
        ArrayList nameList = new ArrayList();
        nameList.add("胶宁高架-银川路");
        nameList.add("安庆路与宁德路路口-银川西路-胶宁高架下桥口");
        nameList.add("杭鞍高架-辽阳路");
        nameList.add("山东路");
        nameList.add("福州路");
        nameList.add("东海路");
        nameList.add("香港路-文登路");
        nameList.add("延安三路");
        nameList.add("贵州-太平-莱阳-南海-正阳关");
        nameList.add("环湾路-杭鞍高架-新冠高架");
        nameList.add("南京路");
        nameList.add("澳门路");
        nameList.add("延安路-宁夏路");
        nameList.add("温州路-重庆路");
        nameList.add("哈尔滨路-黑龙江路");
        nameList.add("杭州路-四流路");
        nameList.add("威海路-人民路");
        nameList.add("瑞昌路");
        nameList.add("延安一路");
        nameList.add("金水路");
        nameList.add("九水路");
        nameList.add("隧道（青岛-黄岛）");
        nameList.add("漓江东路-漓江西路");
        nameList.add("长春路-延吉路");
        nameList.add("海尔路");
        nameList.add("株洲路");
        nameList.add("燕儿岛路");
        nameList.add("深圳路");
        nameList.add("跨海大桥");
        nameList.add("中山路");
        nameList.add("海口-云岭-香港-松岭路");
        nameList.add("仙霞岭路");

        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("section_name", nameList);

        return OK(bisSectionService.list(queryWrapper));

    }
}
