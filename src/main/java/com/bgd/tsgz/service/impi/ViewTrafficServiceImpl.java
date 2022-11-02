package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.ViewTraffic;
import com.bgd.tsgz.mapper.ViewTrafficMapper;
import com.bgd.tsgz.service.ViewTrafficService;
import org.springframework.stereotype.Service;

@Service
public class ViewTrafficServiceImpl extends ServiceImpl<ViewTrafficMapper, ViewTraffic> implements ViewTrafficService {
}
