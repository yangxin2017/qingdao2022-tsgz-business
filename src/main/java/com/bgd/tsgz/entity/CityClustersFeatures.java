package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("city_clusters_features")
@ApiModel("城市群节点特征")
public class CityClustersFeatures {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("城市群名称")
    private String name;
    @ApiModelProperty("城市群活跃度")
    private String vitality;
    @ApiModelProperty("城市群规模")
    private String scale;
    @ApiModelProperty("城市群中心性")
    private String centrality;
}
