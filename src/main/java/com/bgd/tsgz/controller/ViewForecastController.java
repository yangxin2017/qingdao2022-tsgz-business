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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public ResponseData<ViewForecast> getForecastList(String forecastId, String date) throws ParseException {
        QueryWrapper<ViewForecast> queryWrapper = new QueryWrapper<>();
        if(forecastId != null && !forecastId.equals("")){
            queryWrapper.eq("forecastid", forecastId);
        }else{
            return ERROR(101,"forecastId不能为空");
        }
        if(date != null && !date.equals("")){
            // 将date以空格分割，判断长度
            String[] dateArr = date.split(" ");
            if(dateArr.length == 2){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date dates = simpleDateFormat.parse(date);
                queryWrapper.eq("time", dates);
            }else{
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
                // 获取系统当前时间的时分秒
                String date1 = hms.format(new Date());
                // 获取系统当前时间之后一小时的时间点
                String date2 = hms.format(new Date(new Date().getTime() + 60 * 60 * 1000));
                String startTime = date + " " + date1;
                String endTime = date + " " + date2;
                queryWrapper.between("time", simpleDateFormat.parse(startTime), simpleDateFormat.parse(endTime));
            }
        }else{
            return ERROR(101,"date不能为空");
        }

        JSONObject jsonobj = new JSONObject();
        // gis为jsonarray字符串，转换为jsonarray
        for(ViewForecast viewForecast : viewForecastService.list(queryWrapper)){
            JSONObject json = new JSONObject();
            JSONArray gis = new JSONArray();
            // 将position以逗号分割，单位数为lng，双位数为lat，两个一组存入position
            json.put("name", viewForecast.getSectionName());
            json.put("value", viewForecast.getTrafficVolum().split(",")[0]);
//            json.put("time", viewForecast.getTime());
            // time格式化为HH:mm
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = simpleDateFormat.parse(viewForecast.getTime());
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
            json.put("time", simpleDateFormat1.format(date1));
            json.put("id", viewForecast.getSectionCode());

            String[] positionArray = viewForecast.getPosition().split(",");
            for(int j = 0; j < positionArray.length-1; j+=2){
                JSONObject positionItem = new JSONObject();
                positionItem.put("lng", positionArray[j]);
                positionItem.put("lat", positionArray[j+1]);
                gis.add(positionItem);
            }
//            json.put("gis", gis);
            for(int i = 0; i < gis.size() - 1; i++){
                JSONArray gisList = new JSONArray();
                gisList.add(gis.get(i));
                gisList.add(gis.get(i + 1));
                json.put("gis", gisList);
                // jsonobj[time]如果不存在，新建一个jsonarray
                if(jsonobj.get(simpleDateFormat1.format(date1)) == null){
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(json);
                    jsonobj.put(simpleDateFormat1.format(date1), jsonArray);
                }else{
                    // jsonobj[time]如果存在，直接添加
                    JSONArray jsonArray = jsonobj.getJSONArray(simpleDateFormat1.format(date1));
                    jsonArray.add(json);
                }
            }
        }

        return OK(jsonobj);
//        return OK(viewForecastService.list(queryWrapper));
    }
}
