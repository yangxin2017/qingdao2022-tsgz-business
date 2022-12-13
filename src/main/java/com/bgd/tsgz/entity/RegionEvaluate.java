package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("region_evaluate")
@ApiModel("城市评价")
public class RegionEvaluate {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("城市群名称")
    private String name;
    // number,type,unit
    @ApiModelProperty("数量")
    private String number;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("单位")
    private String unit;
    @ApiModelProperty("同步")
    private String sync;
}
