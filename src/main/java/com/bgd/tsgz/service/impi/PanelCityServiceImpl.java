package com.bgd.tsgz.service.impi;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.entity.BisArea;
import com.bgd.tsgz.service.BisAreaService;
import com.bgd.tsgz.service.PanelCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanelCityServiceImpl implements PanelCityService {

    @Autowired
    private BisAreaService bisAreaService;
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
        return data;
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

        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","section","", params,null,false, "tpi");
        return data;
    }

    // 高速拥堵排名
    @Override
    public JSONArray getHighwayCongestionRanking() {
        JSONArray params = new JSONArray();
        params.add("tpi");
        params.add("linecode");

        JSONArray data = getData("/data-server/indices/getIndices", 0,"tsgz","line","", params,null,false, "tpi");
        return data;
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
