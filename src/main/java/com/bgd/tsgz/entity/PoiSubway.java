package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("poi_subway")
@ApiModel("地铁点位")
public class PoiSubway {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("编号")
    private String pid;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("经度")
    private String displayX;
    @ApiModelProperty("纬度")
    private String displayY;
    @ApiModelProperty("区域")
    private String area;
    @ApiModelProperty("类型")
    private String type;
    
}
