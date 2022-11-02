package com.bgd.tsgz.service.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgd.tsgz.entity.ViewSection;
import com.bgd.tsgz.mapper.ViewSectionMapper;
import com.bgd.tsgz.service.ViewSectionService;
import org.springframework.stereotype.Service;

@Service
public class ViewSectionServiceImpl extends ServiceImpl<ViewSectionMapper, ViewSection> implements ViewSectionService {
}
