package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.ViewVideoPoint;
import com.bgd.tsgz.mapper.ViewVideoPointMapper;
import com.bgd.tsgz.service.ViewVideoPointService;
import org.springframework.stereotype.Service;

@Service
public class ViewVideoPointServiceImpl extends ServiceImpl<ViewVideoPointMapper, ViewVideoPoint> implements ViewVideoPointService {
}
