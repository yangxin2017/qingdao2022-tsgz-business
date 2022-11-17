package com.bgd.tsgz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.service.AcdFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.bgd.tsgz.common.ResponseData.OK;
import static java.time.LocalDate.now;

@RestController
@RequestMapping("")
@Api(value = "事故查询", tags = {"事故查询"})
public class AcdfileController {
    @Autowired
    private AcdFileService AcdFileService;

    @GetMapping("getAcdFileList")
    @ApiOperation(value = "事故列表获取", notes = "事故列表获取")
    public ResponseData<AcdFile> getVideoPointList(String time) throws ParseException {
        QueryWrapper<AcdFile> queryWrapper = new QueryWrapper<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "";
        if(time != null && !time.equals("")){
            dateStr = time;
        }else{
            Date date = new Date();
            String today = simpleDateFormat.format(date);
            String month = today.substring(5, 7);
            String day = today.substring(8, 10);
            dateStr = "2018-"+month+"-"+day;
        }

        Date dates = simpleDateFormat.parse(dateStr);
        queryWrapper.eq("sgfssj", dates);

        return OK(AcdFileService.list(queryWrapper));
    }
}
