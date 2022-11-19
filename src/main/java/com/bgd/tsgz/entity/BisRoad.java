package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("bis_road")
@ApiModel("路段表")
public class BisRoad {
    @TableId(type= IdType.ASSIGN_ID)
    @ApiModelProperty("路段编号")
    private String roadCode;

    @ApiModelProperty("行政区划")
    private Integer roadType;
}
