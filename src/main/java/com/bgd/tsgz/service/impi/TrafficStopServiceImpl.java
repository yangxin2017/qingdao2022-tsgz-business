package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.TrafficStop;
import com.bgd.tsgz.mapper.TrafficStopMapper;
import com.bgd.tsgz.service.TrafficStopService;
import org.springframework.stereotype.Service;

@Service
public class TrafficStopServiceImpl extends ServiceImpl<TrafficStopMapper, TrafficStop> implements TrafficStopService {
}
