package com.bgd.tsgz.service.impi;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.entity.BisArea;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.entity.DimHiMainline;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PanelCityServiceImpl implements PanelCityService {

    @Autowired
    private BisAreaService bisAreaService;
    @Autowired
    private BisSectionService bisSectionService;
    @Autowired
    private ViewSectionService viewSectionService;
    @Autowired
    private DimHiMainlineService dimHiMainlineService;
    // 获取实时TPI数据
    @Override
    public JSONObject getTpiList() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","city","tpi",new JSONArray(),null,false);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","city","tpi",new JSONArray(),null,false);
        jsonObject.put("lastData", data);
        return jsonObject;
    }

    // 获取24小时TPI数据
    @Override
    public JSONObject getTpi24List() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getPeriodMeasureRet", 0,"tsgz","city","tpi",new JSONArray(),null,true);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getPeriodMeasureRet", 7,"tsgz","city","tpi",new JSONArray(),null,true);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    // 获取平均速度
    @Override
    public JSONObject getAvgSpeedList() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","city","speed",new JSONArray(),null,false);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","city","speed",new JSONArray(),null,false);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    // 获取在途车辆
    @Override
    public JSONObject getTransitnumList() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getData("/data-server/indices/getSummaryRet", 0,"tsgz","city","transitnum",new JSONArray(),null,false);
        jsonObject.put("nowData", data);

        data = getData("/data-server/indices/getSummaryRet", 7,"tsgz","city","transitnum",new JSONArray(),null,false);
        jsonObject.put("lastData", data);

        return jsonObject;
    }

    // 区域拥堵排名
    @Override
    public JSONArray getCongestionRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("areacode");

        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","area","",params,null,false, "tpi");
        JSONArray result = new JSONArray();
        ArrayList codeList = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            codeList.add(data.getJSONObject(i).getString("areacode"));
        }
        QueryWrapper<BisArea> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("area_code", codeList);
        for (int i = 0; i < data.size(); i++) {
            for (BisArea bisArea : bisAreaService.list(queryWrapper)) {
                if (bisArea.getAreaCode().equals(data.getJSONObject(i).getString("areacode"))) {
                    data.getJSONObject(i).put("name", bisArea.getAreaName());
                    result.add(data.getJSONObject(i));
                    if (result.size() > 10) {
                        result.remove(0);
                    }
                }
            }
        }
        return result;
    }

    // 重点区域拥堵排名
    @Override
    public JSONArray getFocusAreaRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("areacode");
        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","area","",params,null,false, "tpi");

        QueryWrapper<BisArea> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_type", "02");
        JSONArray result = new JSONArray();
        for(int i = 0; i < data.size(); i++) {
            JSONObject item = data.getJSONObject(i);
            for(BisArea area : bisAreaService.list(queryWrapper)) {
                if(area.getAreaCode().equals(item.getString("areacode"))) {
                    item.put("areaName", area.getAreaName());
                    result.add(item);
                    break;
                }
            }
        }
        return result;
    }

    // 路段拥堵排名
    @Override
    public JSONArray getRoadCongestionRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("sectioncode");

        JSONArray data = getData("/data-server/indices/getIndices", 1,"tsgz","section","", params,null,false, "tpi");
        JSONArray result = new JSONArray();
        for(int i = 0; i < data.size(); i++) {
            if(data.getJSONObject(i).get("tpi") == null){
                continue;
            }
            result.add(data.getJSONObject(i));
            if(result.size() > 10) {
                result.remove(0);
            }
        }
        ArrayList codeList = new ArrayList();
        for(int i = 0; i < result.size(); i++) {
            codeList.add(result.getJSONObject(i).getString("sectioncode"));
        }
        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("section_code", codeList);
        ArrayList<BisSection> list = (ArrayList<BisSection>) bisSectionService.list(queryWrapper);
        for(int i = 0; i < result.size(); i++) {
            String code = result.getJSONObject(i).getString("sectioncode");
            JSONObject item = result.getJSONObject(i);
            for(BisSection section : list) {
                if(section.getSectionCode().equals(code)) {
                    item.put("sectionName", section.getSectionName());
                    break;
                }
            }
        }
        return result;
    }

    // 高速拥堵排名
    @Override
    public JSONArray getHighwayCongestionRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("linecode");

        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","line","", params,null,false, "tpi");
        ArrayList codeList = new ArrayList();
        for(int i = 0; i < data.size(); i++) {
            codeList.add(data.getJSONObject(i).getString("linecode"));
        }
        QueryWrapper<DimHiMainline> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("mainlineid", codeList);
        JSONArray result = new JSONArray();
        for(int i = 0; i < data.size(); i++) {
            JSONObject item = data.getJSONObject(i);
            for(DimHiMainline mainline : dimHiMainlineService.list(queryWrapper)) {
                if(mainline.getMainlineid().equals(item.getString("linecode"))) {
                    item.put("lineName", mainline.getMainlinename());
                    result.add(item);
                    if(result.size() > 10) {
                        result.remove(0);
                    }
                    break;
                }
            }
        }
        return result;
    }

    // 重点路段排名
    @Override
    public JSONArray getFocusRoadRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("sectioncode");
        QueryWrapper<ViewSection> queryWrapper = new QueryWrapper<>();
        ArrayList codeList = new ArrayList();
        for(ViewSection section : viewSectionService.list(queryWrapper)) {
            codeList.add(section.getCode());
        }
        QueryWrapper<BisSection> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.in("section_code", codeList);
        ArrayList<BisSection> list = (ArrayList<BisSection>) bisSectionService.list(queryWrapper2);
        JSONArray data = getData("/data-server/indices/getIndices", 1,"tsgz","section","", params,null,false, "tpi");
        JSONArray result = new JSONArray();
        for(int i = 0; i < data.size(); i++) {
            if(data.getJSONObject(i).get("tpi") == null){
                continue;
            }
            // 判断codeList中是否包含该路段
            if(codeList.contains(data.getJSONObject(i).getString("sectioncode"))) {
                for(BisSection section : list) {
                    if(section.getSectionCode().equals(data.getJSONObject(i).getString("sectioncode"))) {
                        data.getJSONObject(i).put("sectionName", section.getSectionName());
                        break;
                    }
                }
                result.add(data.getJSONObject(i));
                if(result.size() > 10) {
                    result.remove(0);
                }
            }
        }


        return result;
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

}
