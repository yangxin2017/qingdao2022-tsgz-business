package com.bgd.tsgz.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewTraffic;
import com.bgd.tsgz.service.ViewTrafficService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "交通路况", tags = {"交通路况"})
public class ViewTrafficController {
    @Autowired
    private ViewTrafficService viewTrafficService;

    @GetMapping("getTrafficList")
    @ApiOperation(value = "获取交通路况列表", notes = "获取交通路况列表")
    public ResponseData getTrafficList() {
        List list = viewTrafficService.getTrafficApiList();
        return OK(list);
    }
    /*public ResponseData<ViewTraffic> getTrafficList(String name) {
        QueryWrapper<ViewTraffic> queryWrapper = new QueryWrapper<>();
        if(name != null && !name.equals("")){
            queryWrapper.like("name", name);
        }

        JSONArray jsonArray = new JSONArray();
        // gis为jsonarray字符串，转换为jsonarray
        for(ViewTraffic viewTraffic : viewTrafficService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewTraffic.getGis());
            json.put("gis", gis);
            json.put("name", viewTraffic.getName());
            json.put("threshold", viewTraffic.getThreshold());
            json.put("value", viewTraffic.getValue());
            json.put("time", viewTraffic.getTime());
            json.put("id", viewTraffic.getId());
            jsonArray.add(json);
        }

        return OK(jsonArray);
    }*/
}
