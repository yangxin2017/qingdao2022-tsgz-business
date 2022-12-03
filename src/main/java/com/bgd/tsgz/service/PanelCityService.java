package com.bgd.tsgz.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface PanelCityService {
    public JSONObject getTpiList();
    public JSONObject getTpi24List();

    // 获取平均速度
    public JSONObject getAvgSpeedList();

    // 获取在途车辆
    public JSONObject getTransitnumList();

    // 区域拥堵排名
    public JSONArray getCongestionRanking();

    // 重点区域拥堵排名
    public JSONArray getFocusAreaRanking();

    // 路段拥堵排名
    public JSONArray getRoadCongestionRanking();

    // 高速拥堵排名
    public JSONArray getHighwayCongestionRanking();

    // 重点路段排名
    public JSONArray getFocusRoadRanking();

    //  停车场
    public JSONObject getParkingList();

    // 城市概况
    public JSONArray getCityOverview();

}
