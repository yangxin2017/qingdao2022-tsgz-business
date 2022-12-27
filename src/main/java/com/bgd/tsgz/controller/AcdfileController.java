package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.entity.LogVo;
import com.bgd.tsgz.entity.ViewAcf;
import com.bgd.tsgz.service.AcdFileService;
import com.bgd.tsgz.service.LogVoService;
import com.bgd.tsgz.service.ViewAcfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
public class AcdfileController extends ComController {
    @Autowired
    private AcdFileService AcdFileService;
    @Autowired
    private ViewAcfService ViewAcfService;
    @Autowired
    private LogVoService logVoService;

    @GetMapping("getAcdFileList")
    @ApiOperation(value = "事故列表获取", notes = "事故列表获取")
    @RequestLog(moduleName = "事故",functionName = "事故列表获取")
    public ResponseData<ViewAcf> getVideoPointList(HttpServletRequest request, String time) throws ParseException {
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
            jsonObject1.put("lng", acdFile .getJdwz().split(",")[0]);
            jsonObject1.put("lat", acdFile.getJdwz().split(",")[1]);
            jsonObject.put("jdwz", jsonObject1);
            jsonArray.add(jsonObject);
        }
//        LogVo logVo = new LogVo();
//        logVo.setSysName("tsgz");
//        logVo.setSaveDate(now().toString());
//        logVo.setLogType("3");
//        logVo.setModuleName("事故");
//        logVo.setFunctionName("查询事故列表");
//        logVo.setLogCode("1");
//        logVo.setUserId("1");
//        logVo.setOperateResult("1");
//        logVo.setDescription("查询成功");
//        logVo.setOperateIp(getIp(request));
//        logVoService.sendLog(logVo);
        return OK(jsonArray);
    }

//    事故统计
    @GetMapping("getAcdFileCount")
    @ApiOperation(value = "事故统计", notes = "事故统计")
    @RequestLog(moduleName = "事故",functionName = "获取事故统计列表")
    public ResponseData<AcdFile> getAcdFileCount(String time,String type) throws ParseException {
//        QueryWrapper<ViewAcf> queryWrapper = new QueryWrapper<>();
        QueryWrapper<AcdFile> queryWrapper = new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(type.equals("1")){
            String startTime = time+"-01";
            String endTime = time+"-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);
//          根据time列进行分类统计
//          获取startTime到endTime的数据
//            queryWrapper.between("time",startdate,enddate);
//            queryWrapper.select("count(*) as count, time");
//            queryWrapper.groupBy("time");
//            queryWrapper.orderByAsc("time");
            queryWrapper.between("sgfssj",startdate,enddate);
            queryWrapper.select("count(*) as count, sgfssj");
            queryWrapper.groupBy("sgfssj");
            queryWrapper.orderByAsc("sgfssj");
        }else if(type.equals("2")){
            String startTime = time+"-01-01";
            String endTime = time+"-12-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);
//            queryWrapper.between("time",startdate,enddate);
//            queryWrapper.select("count(*) as count, to_char(time,'yyyy-MM') as time");
//            queryWrapper.groupBy("to_char(time,'yyyy-MM')");
//            queryWrapper.orderByAsc("to_char(time,'yyyy-MM')");

            queryWrapper.between("sgfssj",startdate,enddate);
            queryWrapper.select("count(*) as count, to_char(sgfssj,'yyyy-MM') as sgfssj");
            queryWrapper.groupBy("to_char(sgfssj,'yyyy-MM')");
            queryWrapper.orderByAsc("to_char(sgfssj,'yyyy-MM')");
        }else if(type.equals("3")){

        }else if(type.equals("4")){
            String startTime = time;
            // endTime为time向后七天的日期
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = new Date(startdate.getTime() + 7 * 24 * 60 * 60 * 1000);
//            queryWrapper.between("time",startdate,enddate);
//            queryWrapper.select("count(*) as count, to_char(time,'yyyy-MM-dd') as time");
//            queryWrapper.groupBy("to_char(time,'yyyy-MM-dd')");
//            queryWrapper.orderByAsc("to_char(time,'yyyy-MM-dd')");
            queryWrapper.between("sgfssj",startdate,enddate);
            queryWrapper.select("count(*) as count, to_char(sgfssj,'yyyy-MM-dd') as sgfssj");
            queryWrapper.groupBy("to_char(sgfssj,'yyyy-MM-dd')");
            queryWrapper.orderByAsc("to_char(sgfssj,'yyyy-MM-dd')");
        }
//        List<Map<String, Object>> list = ViewAcfService.listMaps(queryWrapper);
        List<Map<String, Object>> list = AcdFileService.listMaps(queryWrapper);
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
