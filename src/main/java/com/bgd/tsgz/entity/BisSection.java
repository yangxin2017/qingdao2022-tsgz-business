package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;


@Data
@TableName("bis_section")
@ApiModel("路段")
public class BisSection {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("路段编码")
    private String sectionCode;

    @ApiModelProperty("路段名称")
    private String sectionName;

    @ApiModelProperty("路段类型")
    private String sectionType;

    @ApiModelProperty("所属道路编码")
    private String roadCode;

    @ApiModelProperty("进入方向")
    private String approachDir;

    @ApiModelProperty("路段宽度")
    private String width;

    @ApiModelProperty("车道数")
    private String laneNum;

    @ApiModelProperty("是否有交叉口")
    private String crossFlag;

    @ApiModelProperty("左侧车道数")
    private String leftPktLanes;

    @ApiModelProperty("右侧车道数")
    private String rightPktLanes;

    @ApiModelProperty("路段长度")
    private String length;

    @ApiModelProperty("左侧车道长度")
    private String leftPktLaneLen;

    @ApiModelProperty("右侧车道长度")
    private String rightPktLaneLen;

    @ApiModelProperty("上游交叉口编码")
    private String upCrossingCode;

    @ApiModelProperty("下游交叉口编码")
    private String downCrossingCode;

    @ApiModelProperty("下游路段编码")
    private String downSectionCode;

    @ApiModelProperty("上游路段编码")
    private String upSectionCode;

    @ApiModelProperty("人行道宽度")
    private String sidewalkWidth;

    @ApiModelProperty("是否单行道")
    private String isOneWay;

    @ApiModelProperty("单行道开始时间")
    private Timestamp oneWayStartTime;

    @ApiModelProperty("是否下游右转控制")
    private String isDownRightCtrl;

    @ApiModelProperty("是否有效")
    private String isactive;

    @ApiModelProperty("单行道结束时间")
    private String oneWayEndTime;

    @ApiModelProperty("所属区域编码")
    private String areaCode;

    @ApiModelProperty("速度")
    private String speed;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("位置")
    private String position;

    @ApiModelProperty("创建时间")
    private String creDate;

    @ApiModelProperty("最后修改时间")
    private String lastModDate;

    @ApiModelProperty("所属交通系统编码")
    private String transportSysCode;

    @ApiModelProperty("流量")
    private String flow;

    @ApiModelProperty("上游交叉口方向")
    private String upCrossingDir;

    @ApiModelProperty("下游交叉口方向")
    private String downCrossingDir;

    @ApiModelProperty("几何信息")
    private String geometry;

    @ApiModelProperty("期望速度")
    private String expspeed;

    @ApiModelProperty("标准时间")
    private String stdtime;

}
