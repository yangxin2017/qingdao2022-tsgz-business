package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_carbon_heat")
@ApiModel("碳排放")
public class ViewCarbon {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("lng")
    private String lng;
    @ApiModelProperty("lat")
    private String lat;
    @ApiModelProperty("热力值")
    private String value;
    @ApiModelProperty("阈值")
    private String threshold;
}
