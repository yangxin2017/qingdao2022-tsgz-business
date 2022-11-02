package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.ViewForecast;
import com.bgd.tsgz.mapper.ViewForecastMapper;
import com.bgd.tsgz.service.ViewForecastService;
import org.springframework.stereotype.Service;

@Service
public class ViewForecastServiceImpl extends ServiceImpl<ViewForecastMapper, ViewForecast> implements ViewForecastService {
}
