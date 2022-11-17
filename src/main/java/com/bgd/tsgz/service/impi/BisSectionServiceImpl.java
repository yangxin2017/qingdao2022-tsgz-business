package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.BisSection;
import com.bgd.tsgz.hidata.BisSectionMapper;
import com.bgd.tsgz.service.BisSectionService;
import org.springframework.stereotype.Service;

@Service
public class BisSectionServiceImpl extends ServiceImpl<BisSectionMapper, BisSection> implements BisSectionService {
}
