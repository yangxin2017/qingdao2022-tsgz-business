package com.bgd.tsgz.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bgd.tsgz.entity.IntercityTravel;

public interface IntercityTravelService extends IService<IntercityTravel> {
    public JSONArray getTravelList(String type);
}
