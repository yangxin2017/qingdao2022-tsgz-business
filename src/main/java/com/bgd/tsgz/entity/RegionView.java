package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("region_view")
@ApiModel("区域头部")
public class RegionView {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("type")
    private String type;
}
