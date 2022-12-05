package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("traffic_stop")
@ApiModel("交通站点表")
public class TrafficStop {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("站点名称")
    private String name;
    @ApiModelProperty("经度")
    private String lng;
    @ApiModelProperty("纬度")
    private String lat;
    @ApiModelProperty("站点类型")
    private String type;
}
