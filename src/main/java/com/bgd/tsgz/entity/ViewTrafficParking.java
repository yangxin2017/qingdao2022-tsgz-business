package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_traffic_parking")
@ApiModel("停车位数据")
public class ViewTrafficParking {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    // name,total,free,stopped
    @ApiModelProperty("停车场名称")
    private String name;

    @ApiModelProperty("总车位")
    private Integer total;

    @ApiModelProperty("空闲车位")
    private Integer free;

    @ApiModelProperty("停车车辆")
    private Integer stopped;

}
