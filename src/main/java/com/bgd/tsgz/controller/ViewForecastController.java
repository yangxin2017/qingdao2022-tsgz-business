package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.ViewForecast;
import com.bgd.tsgz.service.ViewForecastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.ERROR;
import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "交通路况预测", tags = {"交通路况预测"})
public class ViewForecastController {
    @Autowired
    private ViewForecastService viewForecastService;

    @GetMapping("getForecastList")
    @ApiOperation(value = "获取交通路况预测列表", notes = "获取交通路况预测列表")
    public ResponseData<ViewForecast> getForecastList(String forecastId, String dateId) {
        QueryWrapper<ViewForecast> queryWrapper = new QueryWrapper<>();
        if(forecastId != null && !forecastId.equals("")){
            queryWrapper.eq("forecastid", forecastId);
        }else{
            return ERROR(101,"forecastId不能为空");
        }
        if(dateId != null && !dateId.equals("")){
            queryWrapper.eq("dateid", dateId);
        }else{
            return ERROR(101,"dateId不能为空");
        }

        JSONObject jsonobj = new JSONObject();
        // gis为jsonarray字符串，转换为jsonarray
        for(ViewForecast viewForecast : viewForecastService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = JSONArray.parseArray(viewForecast.getGis());
            json.put("gis", gis);
            json.put("name", viewForecast.getName());
            json.put("threshold", viewForecast.getThreshold());
            json.put("value", viewForecast.getValue());
            json.put("time", viewForecast.getTime());
            json.put("id", viewForecast.getId());

            // jsonobj[time]如果不存在，新建一个jsonarray
            if(jsonobj.get(viewForecast.getTime()) == null){
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(json);
                jsonobj.put(viewForecast.getTime(), jsonArray);
            }else{
                // jsonobj[time]如果存在，直接添加
                JSONArray jsonArray = jsonobj.getJSONArray(viewForecast.getTime());
                jsonArray.add(json);
            }
        }

        return OK(jsonobj);
    }
}
