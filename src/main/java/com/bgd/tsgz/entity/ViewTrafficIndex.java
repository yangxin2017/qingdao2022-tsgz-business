package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_traffic_index")
@ApiModel("交通运行指数")
public class ViewTrafficIndex {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("拥堵值")
    private Double trafficjam;

    @ApiModelProperty("拥堵周期")
    private Double trafficjamcycle;

    @ApiModelProperty("平均速度")
    private Double speed;

    @ApiModelProperty("平均速度周期")
    private Double speedcycle;

    @ApiModelProperty("车流量")
    private Double vehicle;

    @ApiModelProperty("车流量周期")
    private Double vehiclecycle;

    @ApiModelProperty("时间")
    private String createtime;
}
