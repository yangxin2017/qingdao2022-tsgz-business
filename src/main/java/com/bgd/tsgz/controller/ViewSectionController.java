package com.bgd.tsgz.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.BisRoad;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.BisRoadService;
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
import java.util.List;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "重点路段", tags = {"重点路段"})
public class ViewSectionController {
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private BisSectionService bisSectionService;
    @Autowired
    BisRoadService roadService;

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

        // 获取交通路况
        String url = "http://10.16.7.14:8005/data-server/indices/getIndices";
        JSONObject params = new JSONObject();
        params.put("token", "tsgz");
        params.put("geoDim","section");
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - 20 * 60 * 1000 - 24*60*60*1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - 15 * 60 * 1000 - 24*60*60*1000));
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        JSONArray columns = new JSONArray();
        columns.add("tpibynet");
        columns.add("sectioncode");
        params.put("columns", columns);

        JSONObject query = new JSONObject();
        query.put("field", "sectioncode");
        query.put("values", codeList);
        JSONArray querys = new JSONArray();
        querys.add(query);
        params.put("queryParams", querys);


        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");


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
                for(int k = 0; k < data.size(); k++){
                    JSONObject dataItem = data.getJSONObject(k);
                    if(dataItem.getString("sectioncode").equals(bisSection.getSectionCode())){
                        json.put("value", dataItem.getString("tpibynet"));
                    }
                }
                jsonArray.add(json);
            }
        }
        return OK(jsonArray);

    }


    private boolean isImpRoad(String roadCode, List<BisRoad> allRoads) {
        List<Integer> impTypes = new ArrayList<>();
        impTypes.add(1);
        impTypes.add(2);
        impTypes.add(3);
        impTypes.add(4);
        impTypes.add(8);
        impTypes.add(9);

        boolean isImp = false;
        for(BisRoad road: allRoads) {
            if (road.getRoadCode().equals(roadCode)) {
                if (impTypes.contains(road.getRoadType())) {
                    isImp = true;
                    break;
                }
            }
        }
        return isImp;
    }
}
