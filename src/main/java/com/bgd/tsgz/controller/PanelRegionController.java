package com.bgd.tsgz.controller;

import com.bgd.tsgz.common.ResponseData;
import com.bgd.tsgz.entity.AcdFile;
import com.bgd.tsgz.service.DriveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bgd.tsgz.common.ResponseData.OK;

@RestController
@RequestMapping("")
@Api(value = "面板数据-区域级", tags = {"面板数据-区域级"})
public class PanelRegionController {

    @Autowired
    private DriveService driveService;

    @GetMapping("getDriveInList")
    @ApiOperation(value = "获取驶入车辆周期数据", notes = "获取驶入车辆周期数据")
    public ResponseData<AcdFile> getDriveInList(){
        return OK(driveService.getDriveInCycle());
    }

    @GetMapping("getDriveOutList")
    @ApiOperation(value = "获取驶出车辆周期数据", notes = "获取驶出车辆周期数据")
    public ResponseData<AcdFile> getDriveOutList(){
        return OK(driveService.getDriveOutCycle());
    }

    @GetMapping("getDriveIn24Hour")
    @ApiOperation(value = "获取24小时驶入车辆变化趋势", notes = "获取24小时驶入车辆变化趋势")
    public ResponseData<AcdFile> getDriveIn24Hour(){
        return OK(driveService.getDriveIn24Hour());
    }

    @GetMapping("getDriveOut24Hour")
    @ApiOperation(value = "获取24小时驶出车辆变化趋势", notes = "获取24小时驶出车辆变化趋势")
    public ResponseData<AcdFile> getDriveOut24Hour(){
        return OK(driveService.getDriveOut24Hour());
    }

    @GetMapping("getCongestionIndex")
    @ApiOperation(value = "获取拥堵指数", notes = "获取拥堵指数")
    public ResponseData<AcdFile> getCongestionIndex(){
        return OK(driveService.getCongestionIndex());
    }

    @GetMapping("getAverageSpeed")
    @ApiOperation(value = "获取平均速度", notes = "获取平均速度")
    public ResponseData<AcdFile> getAverageSpeed(){
        return OK(driveService.getAverageSpeed());
    }

    @GetMapping("getTransitnum")
    @ApiOperation(value = "获取在途车辆", notes = "获取在途车辆")
    public ResponseData<AcdFile> getTransitnum(){
        return OK(driveService.getTransitnum());
    }

    @GetMapping("getRank")
    @ApiOperation(value = "获取指数和速度排名", notes = "获取指数和速度排名")
    public ResponseData<AcdFile> getRank(){
        return OK(driveService.getRank());
    }

    @GetMapping("getSectionFlow")
    @ApiOperation(value = "获取流量排名", notes = "获取流量排名")
    public ResponseData<AcdFile> getSectionFlow(){
        return OK(driveService.getSectionFlow());
    }
}