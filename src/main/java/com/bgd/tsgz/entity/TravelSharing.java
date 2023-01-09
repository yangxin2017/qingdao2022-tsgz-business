package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("travel_sharing")
@ApiModel("出行分担")
public class TravelSharing {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("单位")
    private String unit;
    @ApiModelProperty("类型")
    private String type;
}
