package com.bgd.tsgz.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface DriveService {
    // 驶入车辆
    public JSONObject getDriveInCycle();

    // 驶出车辆
    public JSONObject getDriveOutCycle();

    // 24小时驶入车辆变化趋势
    public JSONObject getDriveIn24Hour();

    // 24小时驶出车辆变化趋势
    public JSONObject getDriveOut24Hour();

    // 拥堵指数
    public JSONObject getCongestionIndex();

    //平均速度
    public JSONObject getAverageSpeed(String areaCode);

    // 在途车辆
    public JSONObject getTransitnum(String areaCode);

    // 指数和速度排名
    public JSONObject getRank(String areaCode);

    // 流量排名
    public JSONArray getSectionFlow();

    // 区域路段排名
    public JSONArray getSectionRank();

    // 区域头部
    public JSONObject getRegionHead();
}
