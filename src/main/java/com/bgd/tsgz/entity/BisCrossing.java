package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.security.Timestamp;


@Data
@TableName("bis_crossing")
@ApiModel("路口")
public class BisCrossing {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("路口编码")
    private String crossingCode;
    @ApiModelProperty("路口名称")
    private String crossingName;
    @ApiModelProperty("区域")
    private String area;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("路口类型")
    private String crossingType;
    @ApiModelProperty("经度")
    private String longitude;
    @ApiModelProperty("纬度")
    private String latitude;
    @ApiModelProperty("高速路口")
    private String hiconCrossing;
    @ApiModelProperty("创建时间")
    private Timestamp creDate;
    @ApiModelProperty("最后修改时间")
    private Timestamp lastModDate;
    @ApiModelProperty("交通系统编码")
    private String transportSysCode;
    @ApiModelProperty("宽度")
    private String width;
    @ApiModelProperty("几何")
    private String geometry;
    @ApiModelProperty("道路代码")
    private String dldm;
    @ApiModelProperty("部门代码")
    private String bmdm;
    @ApiModelProperty("交叉道路类型")
    private String jcdl;
    @ApiModelProperty("路口道路类型")
    private String crossingRoadType;

}
