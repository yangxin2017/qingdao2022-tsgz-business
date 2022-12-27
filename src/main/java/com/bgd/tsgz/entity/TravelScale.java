package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("travel_scale")
@ApiModel("出行规模")
public class TravelScale {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("经度")
    private String lng;
    @ApiModelProperty("纬度")
    private String lat;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("值")
    private String value;



}
