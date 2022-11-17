package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("bis_area")
@ApiModel("区域")
public class BisArea {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("区域编号")
    private String areaCode;

    @ApiModelProperty("区域名称")
    private String areaName;

    @ApiModelProperty("区域坐标")
    private String coordinate;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("中心点")
    private String center;

    @ApiModelProperty("简称")
    private String shortName;

    @ApiModelProperty("部门编号")
    private String departmentCode;

    @ApiModelProperty("区域类型")
    private String areaType;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("创建时间")
    private Date creatTime;
    
}
