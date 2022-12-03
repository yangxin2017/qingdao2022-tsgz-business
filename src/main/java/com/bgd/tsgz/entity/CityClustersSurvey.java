package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("city_clusters_survey")
@ApiModel("城市群概况")
public class CityClustersSurvey {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("value")
    private String value;
    @ApiModelProperty("unit")
    private String unit;
}
