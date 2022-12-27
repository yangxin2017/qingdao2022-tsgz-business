package com.bgd.tsgz.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bgd.tsgz.entity.RegionEvaluate;

public interface RegionEvaluateService extends IService<RegionEvaluate> {
    /*getRegionTpi24List*/
    public JSONObject getRegionTpi24List(String type, String time) throws Exception;
}
