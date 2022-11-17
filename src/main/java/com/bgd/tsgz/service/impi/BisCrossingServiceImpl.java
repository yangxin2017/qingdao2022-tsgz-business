package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.BisCrossing;
import com.bgd.tsgz.hidata.BisCrossingMapper;
import com.bgd.tsgz.service.BisCrossingService;
import org.springframework.stereotype.Service;

@Service
public class BisCrossingServiceImpl extends ServiceImpl<BisCrossingMapper, BisCrossing> implements BisCrossingService {
}
