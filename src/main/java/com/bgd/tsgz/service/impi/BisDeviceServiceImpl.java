package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.BisDevice;
import com.bgd.tsgz.hidata.BisDeviceMapper;
import com.bgd.tsgz.service.BisDeviceService;
import org.springframework.stereotype.Service;

@Service
public class BisDeviceServiceImpl extends ServiceImpl<BisDeviceMapper, BisDevice> implements BisDeviceService {
}
