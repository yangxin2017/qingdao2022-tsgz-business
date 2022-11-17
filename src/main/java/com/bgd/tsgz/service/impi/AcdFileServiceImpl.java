package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.hidata.AcdFileMapper;
import com.bgd.tsgz.service.AcdFileService;
import org.springframework.stereotype.Service;

@Service
public class AcdFileServiceImpl extends ServiceImpl<AcdFileMapper, AcdFile> implements AcdFileService {
}
