package com.bgd.tsgz.service.impi;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.BisRoad;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.entity.ViewTraffic;
import com.bgd.tsgz.mapper.ViewTrafficMapper;
import com.bgd.tsgz.service.BisRoadService;
import com.bgd.tsgz.service.BisSectionService;
import com.bgd.tsgz.service.ViewTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewTrafficServiceImpl extends ServiceImpl<ViewTrafficMapper, ViewTraffic> implements ViewTrafficService {
    @Autowired
    BisSectionService bisSectionService;

    @Autowired
    BisRoadService roadService;

    @Override
    public ArrayList getTrafficApiList() {
        String url = "http://10.16.7.14:8005/data-server/indices/getIndices";
        JSONObject params = new JSONObject();
        params.put("token", "tsgz");
        params.put("geoDim","section");
        String starttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - 20 * 60 * 1000 - 24*60*60*1000));
        String endttime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() - 15 * 60 * 1000 - 24*60*60*1000));
        params.put("startTime", starttime);
        params.put("endTime", endttime);
        JSONArray columns = new JSONArray();
        columns.add("tpibynet");
        columns.add("sectioncode");
        params.put("columns", columns);
        String result = HttpUtil.post(url, params.toJSONString());
        JSONObject resultJson = JSONObject.parseObject(result);
        JSONArray data = resultJson.getJSONArray("result");
        ArrayList list = new ArrayList<>();

        List<BisRoad> allRoads = roadService.list();

        QueryWrapper<BisSection> queryWrapper = new QueryWrapper<>();
        List<BisSection> bisSectionList = bisSectionService.list(queryWrapper);
        for(int i = 0; i < data.size(); i++){
            JSONObject json = new JSONObject();
            JSONObject item = data.getJSONObject(i);
            String sectioncode = item.getString("sectioncode");
            for(BisSection bisSection : bisSectionList){
                // sectioncode!=null并且bisSection.getSection_code()不为null
                if(bisSection.getSectionCode().equals(sectioncode)){
                    JSONArray position = new JSONArray();
                    // 将position以逗号分割，单位数为lng，双位数为lat，两个一组存入position
                    String[] positionArray = bisSection.getPosition().split(",");
                    for(int j = 0; j < positionArray.length-1; j+=2){
                        JSONObject positionItem = new JSONObject();
                        positionItem.put("lng", positionArray[j]);
                        positionItem.put("lat", positionArray[j+1]);
                        position.add(positionItem);
                    }
                    if(isImpRoad(bisSection.getRoadCode(), allRoads)) {
                        for (int j=0;j<position.size()-1;j++) {
                            JSONArray arr = new JSONArray();
                            arr.add(position.getJSONObject(j));
                            arr.add(position.getJSONObject(j + 1));

                            json.put("name", bisSection.getSectionName());
                            json.put("gis", arr);
                            if(item.getString("tpibynet")!=null){
                                json.put("value", item.getString("tpibynet"));
                            }else{
                                json.put("value", 0);
                            }
                            json.put("id", bisSection.getSectionCode());
                            json.put("width", bisSection.getWidth());
//                                json.put("height",0);
                            list.add(json);
                        }
                    }
                    break;
                }
            }
        }

        return list;
    }

    private boolean isImpRoad(String roadCode, List<BisRoad> allRoads) {
        return true;
//        List<Integer> impTypes = new ArrayList<>();
//        impTypes.add(1);
//        impTypes.add(2);
//        impTypes.add(3);
//        impTypes.add(4);
//        impTypes.add(8);
//        impTypes.add(9);
//
//        boolean isImp = false;
//        for(BisRoad road: allRoads) {
//            if (road.getRoadCode().equals(roadCode)) {
//                if (impTypes.contains(road.getRoadType())) {
//                    isImp = true;
//                    break;
//                }
//            }
//        }
//        return isImp;
    }
}
