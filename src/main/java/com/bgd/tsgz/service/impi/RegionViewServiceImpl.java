package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.RegionView;
import com.bgd.tsgz.mapper.RegionViewMapper;
import com.bgd.tsgz.service.RegionViewService;
import org.springframework.stereotype.Service;

@Service
public class RegionViewServiceImpl extends ServiceImpl<RegionViewMapper, RegionView> implements RegionViewService {
}
