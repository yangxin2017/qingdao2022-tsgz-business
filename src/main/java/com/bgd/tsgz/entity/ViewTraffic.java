package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_traffic")
@ApiModel("交通路况")
public class ViewTraffic {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("gis")
    private String gis;
    @ApiModelProperty("阈值")
    private String threshold;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("拥堵值")
    private String value;
    @ApiModelProperty("时间")
    private String time;
}
