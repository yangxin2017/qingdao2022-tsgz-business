package com.bgd.tsgz.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.aspect.RequestLog;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.entity.LogVo;
import com.bgd.tsgz.entity.ViewAcf;
import com.bgd.tsgz.entity.ViewAcfDetails;
import com.bgd.tsgz.service.AcdFileService;
import com.bgd.tsgz.service.LogVoService;
import com.bgd.tsgz.service.ViewAcfDetailsService;
import com.bgd.tsgz.service.ViewAcfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
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
    private ViewAcfDetailsService viewAcfDetailsService;

    @GetMapping("getAcdFileList")
    @ApiOperation(value = "事故列表获取", notes = "事故列表获取")
    @RequestLog(moduleName = "事故",functionName = "事故列表获取")
    public ResponseData<ViewAcf> getVideoPointList( String time) throws ParseException {
        QueryWrapper<ViewAcf> queryWrapper = new QueryWrapper<>();
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
        return OK(jsonArray);
    }

    // 事故列表详情获取
    @GetMapping("getAcdFileListDetails")
    @ApiOperation(value = "事故列表详情获取", notes = "事故列表详情获取")
    @RequestLog(moduleName = "事故",functionName = "事故列表详情获取")
    public ResponseData getAcdFile(String time) {
        QueryWrapper<ViewAcfDetails> queryWrapper = new QueryWrapper<>();
        JSONArray result = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 循环遍历
        for(ViewAcfDetails acf : viewAcfDetailsService.list(queryWrapper)){
            JSONObject row = new JSONObject();
            JSONObject callThePolice = JSONObject.parseObject(acf.getCallThePolice());
            JSONObject confirm = JSONObject.parseObject(acf.getConfirm());
            JSONObject dispatchPolice = JSONObject.parseObject(acf.getDispatchPolice());
            JSONObject closingTheAlarm = JSONObject.parseObject(acf.getClosingTheAlarm());
            // time格式为Timestampm，格式化为yyyy-MM-dd HH:mm:ss
            String date = sdf.format(acf.getTime());
            row.put("time", date);
            row.put("type", acf.getType());
            row.put("source", acf.getSource());
            row.put("address", acf.getAddress());
            row.put("belonging", acf.getBelonging());
            row.put("describe", acf.getDescribe());
            row.put("callThePolice", callThePolice);
            row.put("confirm", confirm);
            row.put("dispatchPolice", dispatchPolice);
            row.put("closingTheAlarm", closingTheAlarm);
            // 将acf.getVideo()以逗号分割
            String[] video = acf.getVideo().split(",");
            row.put("videoList", video);
            // position以逗号分隔
            String[] position = acf.getPosition().split(",");
            row.put("lng", position[0]);
            row.put("lat", position[1]);
            result.add(row);
        }
        return OK(result);
    }

//    事故统计
    @GetMapping("getAcdFileCount")
    @ApiOperation(value = "事故统计", notes = "事故统计")
    @RequestLog(moduleName = "事故",functionName = "获取事故统计列表")
    public ResponseData<AcdFile> getAcdFileCount(String time,String type,String areaCode) throws ParseException {
        QueryWrapper<AcdFile> queryWrapper = new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(areaCode != null && !areaCode.equals("")){
            queryWrapper.eq("xzqh", areaCode);
        }
        if(type.equals("1")){
            String startTime = time+"-01";
            String endTime = time+"-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);
            queryWrapper.between("sgfssj",startdate,enddate);
            queryWrapper.select("count(*) as count, sgfssj");
            queryWrapper.groupBy("sgfssj");
            queryWrapper.orderByAsc("sgfssj");
        }else if(type.equals("2")){
            String startTime = time+"-01-01";
            String endTime = time+"-12-31";
            Date startdate = simpleDateFormat.parse(startTime);
            Date enddate = simpleDateFormat.parse(endTime);

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
            queryWrapper.between("sgfssj",startdate,enddate);
            queryWrapper.select("count(*) as count, to_char(sgfssj,'yyyy-MM-dd') as sgfssj");
            queryWrapper.groupBy("to_char(sgfssj,'yyyy-MM-dd')");
            queryWrapper.orderByAsc("to_char(sgfssj,'yyyy-MM-dd')");
        }
        List<Map<String, Object>> list = AcdFileService.listMaps(queryWrapper);
        return OK(list);
    }
}
