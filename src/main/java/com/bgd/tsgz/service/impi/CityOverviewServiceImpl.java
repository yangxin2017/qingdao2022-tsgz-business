package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.CityOverview;
import com.bgd.tsgz.mapper.CityOverviewMapper;
import com.bgd.tsgz.service.CityOverviewService;
import org.springframework.stereotype.Service;

@Service
public class CityOverviewServiceImpl extends ServiceImpl<CityOverviewMapper, CityOverview> implements CityOverviewService {
}
