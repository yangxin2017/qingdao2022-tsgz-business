package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.ComInfoTb;
import com.bgd.tsgz.hidata.ComInfoTbMapper;
import com.bgd.tsgz.service.ComInfoTbService;
import org.springframework.stereotype.Service;

@Service
public class ComInfoTbServiceImpl extends ServiceImpl<ComInfoTbMapper, ComInfoTb> implements ComInfoTbService {
}
