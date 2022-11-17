package com.bgd.tsgz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgd.tsgz.entity.ViewTraffic;

import java.util.ArrayList;
import java.util.List;

public interface ViewTrafficService extends IService<ViewTraffic> {
    public List getTrafficApiList();
}
