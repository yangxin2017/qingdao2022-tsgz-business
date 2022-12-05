package com.bgd.tsgz.service.impi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.IntercityTravel;
import com.bgd.tsgz.mapper.IntercityTravelMapper;
import com.bgd.tsgz.service.IntercityTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntercityTravelServiceImpl extends ServiceImpl<IntercityTravelMapper, IntercityTravel> implements IntercityTravelService {
    @Override
    public JSONArray getTravelList(String type) {
        QueryWrapper<IntercityTravel> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", type);
        JSONArray result = new JSONArray();
        for (IntercityTravel intercityTravel : list(queryWrapper)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", intercityTravel.getId());
            jsonObject.put("value", intercityTravel.getValue());
            JSONArray gislist = new JSONArray();
            JSONObject gis = new JSONObject();
            gis.put("lng", intercityTravel.getSposition().split(",")[0]);
            gis.put("lat", intercityTravel.getSposition().split(",")[1]);
            gis.put("name", intercityTravel.getSname());
            gislist.add(gis);
            gis = new JSONObject();
            gis.put("lng", intercityTravel.getEposition().split(",")[0]);
            gis.put("lat", intercityTravel.getEposition().split(",")[1]);
            gis.put("name", intercityTravel.getEname());
            gislist.add(gis);
            jsonObject.put("gis", gislist);
            result.add(jsonObject);
        }
        return result;
    }
}
