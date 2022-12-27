package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.VolumPrediction;
import com.bgd.tsgz.mapper.VolumPredictionMapper;
import com.bgd.tsgz.service.VolumPredictionService;
import org.springframework.stereotype.Service;

@Service
public class VolumPredictionServiceImpl extends ServiceImpl<VolumPredictionMapper, VolumPrediction> implements VolumPredictionService {
}
