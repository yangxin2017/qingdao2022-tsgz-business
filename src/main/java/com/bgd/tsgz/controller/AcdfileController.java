package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.entity.ViewAcf;
import com.bgd.tsgz.service.AcdFileService;
import com.bgd.tsgz.service.ViewAcfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.bgd.tsgz.common.ResponseData.OK;
import static java.time.LocalDate.now;

@RestController
@RequestMapping("")
@Api(value = "事故查询", tags = {"事故查询"})
public class AcdfileController {
    @Autowired
    private AcdFileService AcdFileService;
    @Autowired
    private ViewAcfService ViewAcfService;

    @GetMapping("getAcdFileList")
    @ApiOperation(value = "事故列表获取", notes = "事故列表获取")
    public ResponseData<ViewAcf> getVideoPointList(String time) throws ParseException {
        QueryWrapper<ViewAcf> queryWrapper = new QueryWrapper<>();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr = "";
//        if(time != null && !time.equals("")){
//            dateStr = time;
//        }else{
//            Date date = new Date();
//            String today = simpleDateFormat.format(date);
//            String month = today.substring(5, 7);
//            String day = today.substring(8, 10);
//            dateStr = "2018-"+month+"-"+day;
//        }
//
//        Date dates = simpleDateFormat.parse(dateStr);
//        queryWrapper.eq("sgfssj", dates);

        JSONArray jsonArray = new JSONArray();
        for (ViewAcf acdFile : ViewAcfService.list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("time", acdFile.getTime());
            jsonObject.put("sglx", acdFile.getSglx());
            jsonObject.put("sgdd", acdFile.getSgdd());
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("lng", acdFile.getJdwz().split(",")[0]);
            jsonObject1.put("lat", acdFile.getJdwz().split(",")[1]);
            jsonObject.put("jdwz", jsonObject1);
            jsonArray.add(jsonObject);
        }

        return OK(jsonArray);
    }

//    事故统计
    @GetMapping("getAcdFileCount")
    @ApiOperation(value = "事故统计", notes = "事故统计")
    public ResponseData<ViewAcf> getAcdFileCount(String time,String type) throws ParseException {
        QueryWrapper<ViewAcf> queryWrapper = new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(type.equals("1")){
            String startTime = time+"-01";
            String endTime = time+"-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);
//        根据time列进行分类统计
//            获取startTime到endTime的数据
            queryWrapper.between("time",startdate,enddate);
            queryWrapper.select("count(*) as count, time");
            queryWrapper.groupBy("time");
            queryWrapper.orderByAsc("time");
        }else if(type.equals("2")){
            String startTime = time+"-01-01";
            String endTime = time+"-12-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);
            queryWrapper.between("time",startdate,enddate);
//            postgrea对数据按月份进行分类统计
            queryWrapper.select("count(*) as count, to_char(time,'yyyy-MM') as time");
            queryWrapper.groupBy("to_char(time,'yyyy-MM')");
            queryWrapper.orderByAsc("to_char(time,'yyyy-MM')");
        }
        List<Map<String, Object>> list = ViewAcfService.listMaps(queryWrapper);
//        ViewAcfService.count(queryWrapper);
//        JSONObject jsonObject = new JSONObject();
//        for(ViewAcf acdFile : ViewAcfService.list(queryWrapper)){
//            if(jsonObject.containsKey(acdFile.getTime())){
//                jsonObject.put(acdFile.getTime(), jsonObject.getInteger(acdFile.getTime())+1);
//            }else{
//                jsonObject.put(acdFile.getTime(), 1);
//            }
//        }
        return OK(list);
    }
}
