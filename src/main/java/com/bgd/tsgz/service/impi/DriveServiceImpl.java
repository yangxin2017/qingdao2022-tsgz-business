package com.bgd.tsgz.service.impi;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.entity.BisAreaSection;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.entity.RegionView;
import com.bgd.tsgz.service.BisAreaSectionService;
import com.bgd.tsgz.service.BisSectionService;
import com.bgd.tsgz.service.DriveService;
import com.bgd.tsgz.service.RegionViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriveServiceImpl implements DriveService {
    @Autowired
    private BisSectionService bisSectionService;
    @Autowired
    private BisAreaSectionService bisAreaSectionService;
    @Autowired
    private RegionViewService regionViewService;

    @Override
    public JSONObject getDriveInCycle() {
        JSONObject jsonObject = new JSONObject();

        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","area","inflow",new JSONArray(),"1h",60,0,null);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","area","inflow",new JSONArray(),"1h",60,0,null);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getDriveOutCycle() {
        JSONObject jsonObject = new JSONObject();

        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","area","outflow",new JSONArray(),"1h",60,0,null);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","area","outflow",new JSONArray(),"1h",60,0,null);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getDriveIn24Hour() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getPeriodMeasureRet", 0,"tsgz","area","inflow",new JSONArray(),"",true);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getPeriodMeasureRet", 7,"tsgz","area","inflow",new JSONArray(),"",true);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getDriveOut24Hour() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getPeriodMeasureRet", 0,"tsgz","area","outflow",new JSONArray(),"",true);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getPeriodMeasureRet", 7,"tsgz","area","outflow",new JSONArray(),"",true);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getCongestionIndex() {
        JSONObject jsonObject = new JSONObject();

        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","area","tpi",new JSONArray(),"1h",60,0,null);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","area","tpi",new JSONArray(),"1h",60,0,null);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getAverageSpeed() {
        JSONObject jsonObject = new JSONObject();

        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","area","speed",new JSONArray(),"1h",60,0,null);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","area","speed",new JSONArray(),"1h",60,0,null);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getTransitnum() {
        JSONObject jsonObject = new JSONObject();

        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","area","transitnum",new JSONArray(),"1h",60,0,null);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","area","transitnum",new JSONArray(),"1h",60,0,null);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    @Override
    public JSONObject getRank() {
        JSONObject jsonObject = new JSONObject();
        JSONArray param = new JSONArray();
        param.add("tpi");
        param.add("areacode");

        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","area","",param,"1h",60,0,"tpi");
        jsonObject.put("tpi", data);

        param.clear();
        param.add("speed");
        param.add("areacode");
        data = getData("/data-server/indices/getIndices", 0,"tsgz","area","",param,"1h",60,0,"speed");
        jsonObject.put("speed", data);

        return jsonObject;
    }

    @Override
    public JSONArray getSectionFlow() {
        JSONArray param = new JSONArray();
        param.add("flow");
        param.add("sectioncode");

        JSONArray data = getData("/data-server/indices/getIndices", 1,"tsgz","section","",param,"",20,15,"flow");
        ArrayList codeList = new ArrayList();
        for(int i = 0; i < data.size(); i++){
            JSONObject jsonObject = data.getJSONObject(i);
            if(jsonObject.get("flow") == null){
                continue;
            }
            codeList.add(data.getJSONObject(i).getString("sectioncode"));
        }
        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("section_code", codeList);
        List<BisSection> bisSections = bisSectionService.list(queryWrapper);
        JSONArray result = new JSONArray();

        for (int i = 0; i < data.size(); i++) {
            JSONObject jsonObject = data.getJSONObject(i);
            // 判断flow是否为null
            if(jsonObject.get("flow") == null){
                continue;
            }
            for (BisSection bisSection : bisSections) {
                if (bisSection.getSectionCode().equals(jsonObject.getString("sectioncode"))) {
                    jsonObject.put("name", bisSection.getSectionName());
                    result.add(jsonObject);
                    break;
                }
            }
        }
        return result;
    }

//    getSectionRank
    @Override
    public JSONArray getSectionRank() {
        QueryWrapper<BisAreaSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("areaid", "f8fe7f49c3c2400498cb5d2b349594a8");
        List<BisAreaSection> bisAreaSections = bisAreaSectionService.list(queryWrapper);
        ArrayList codeList = new ArrayList();
        for (BisAreaSection bisAreaSection : bisAreaSections) {
            codeList.add(bisAreaSection.getSectioncode());
        }


        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("sectioncode");
        params.add("speed");
        ArrayList queryParams = new ArrayList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("field", "sectioncode");
        jsonObject.put("values", codeList);
        queryParams.add(jsonObject);
        JSONArray data = getData("/data-server/indices/getIndices", 1,"tsgz","section","", params,null,false, "tpi",queryParams);

        QueryWrapper <BisSection> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.in("section_code", codeList);
        List<BisSection> bisSections = bisSectionService.list(sectionQueryWrapper);
        JSONArray result = new JSONArray();
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = data.getJSONObject(i);
            if(data.getJSONObject(i).get("tpi") == null){
                continue;
            }
            for (BisSection bisSection : bisSections) {
                if (bisSection.getSectionCode().equals(object.getString("sectioncode"))) {
                    object.put("name", bisSection.getSectionName());
                    result.add(object);
                    break;
                }
            }
        }
        return result;
    }

    // getRegionHead
    @Override
    public JSONObject getRegionHead(){
        QueryWrapper<RegionView> queryWrapper = new QueryWrapper<>();
        // 获取一条
        queryWrapper.last("limit 1");
        RegionView regionView = regionViewService.getOne(queryWrapper);
        return JSONObject.parseObject(JSONObject.toJSONString(regionView));
    }

    public JSONArray getData(String url, Integer timeLast, String token, String geoDim, String measureColumn, JSONArray columns, String timeDim, Boolean isAll){
        url = "http://10.16.7.14:8005" + url;
        JSONObject params = new JSONObject();
        params.put("token", token);
        params.put("geoDim",geoDim);
        if(timeDim != null){
            params.put("timeDim",timeDim);
        }
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 20 * 60 * 1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 15 * 60 * 1000));
        if(isAll){
            starttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 00:00:00";
            endttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 23:59:59";
        }
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        params.put("columns", columns);
        params.put("measureColumn",measureColumn);
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        return data;
    }
    public JSONArray getData(String url, Integer timeLast, String token, String geoDim, String measureColumn, JSONArray columns, String timeDim,int st,int et, String orderBy){
        url = "http://10.16.7.14:8005" + url;
        JSONObject params = new JSONObject();
        params.put("token", token);
        params.put("geoDim",geoDim);
        if(timeDim != null){
            params.put("timeDim",timeDim);
        }
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - st * 60 * 1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - et * 60 * 1000));
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        params.put("columns", columns);
        params.put("measureColumn",measureColumn);
        if (orderBy!=null){
            params.put("orderBy", orderBy);
        }
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        return data;
    }

    public JSONArray getData(String url, Integer timeLast, String token, String geoDim, String measureColumn, JSONArray columns, String timeDim,int st,int et, String orderBy,ArrayList queryParams){
        url = "http://10.16.7.14:8005" + url;
        JSONObject params = new JSONObject();
        params.put("token", token);
        params.put("geoDim",geoDim);
        if(timeDim != null){
            params.put("timeDim",timeDim);
        }
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - st * 60 * 1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - et * 60 * 1000));
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        params.put("columns", columns);
        params.put("measureColumn",measureColumn);
        if (orderBy!=null){
            params.put("orderBy", orderBy);
        }
        if(queryParams != null){
            params.put("queryParams", queryParams);
        }
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        return data;
    }

    public JSONArray getData(String url, Integer timeLast, String token, String geoDim, String measureColumn, JSONArray columns, String timeDim, Boolean isAll, String orderBy){
        url = "http://10.16.7.14:8005" + url;
        JSONObject params = new JSONObject();
        params.put("token", token);
        params.put("geoDim",geoDim);
        if(timeDim != null){
            params.put("timeDim",timeDim);
        }
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 20 * 60 * 1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 15 * 60 * 1000));
        if(isAll){
            starttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 00:00:00";
            endttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 23:59:59";
        }
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        params.put("columns", columns);
        params.put("measureColumn",measureColumn);
        if (orderBy!=null){
            params.put("orderBy", orderBy);
        }
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        return data;
    }

    public JSONArray getData(String url, Integer timeLast, String token, String geoDim, String measureColumn, JSONArray columns, String timeDim, Boolean isAll, String orderBy,ArrayList queryParams){
        url = "http://10.16.7.14:8005" + url;
        JSONObject params = new JSONObject();
        params.put("token", token);
        params.put("geoDim",geoDim);
        if(timeDim != null){
            params.put("timeDim",timeDim);
        }
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 20 * 60 * 1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000 - 15 * 60 * 1000));
        if(isAll){
            starttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 00:00:00";
            endttime = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(System.currentTimeMillis() - timeLast * 24 * 60 * 60 * 1000)) + " 23:59:59";
        }
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        params.put("columns", columns);
        params.put("measureColumn",measureColumn);
        if (orderBy!=null){
            params.put("orderBy", orderBy);
        }
        if(queryParams != null){
            params.put("queryParams", queryParams);
        }
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        return data;
    }

}
