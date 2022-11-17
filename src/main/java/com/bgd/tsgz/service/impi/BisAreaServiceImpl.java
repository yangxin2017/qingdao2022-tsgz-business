package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.BisArea;
import com.bgd.tsgz.hidata.BisAreaMapper;
import com.bgd.tsgz.service.BisAreaService;
import org.springframework.stereotype.Service;

@Service
public class BisAreaServiceImpl extends ServiceImpl<BisAreaMapper, BisArea> implements BisAreaService {
}
