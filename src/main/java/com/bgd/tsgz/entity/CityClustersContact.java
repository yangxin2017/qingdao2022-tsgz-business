package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("city_clusters_contact")
@ApiModel("城市群城市联系特征")
public class CityClustersContact {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("城市群名称")
    private String name;
    @ApiModelProperty("首位城市")
    private String first;
    @ApiModelProperty("流量")
    private String flow;
    @ApiModelProperty("起始位置")
    private String sposition;
    @ApiModelProperty("结束位置")
    private String eposition;
}
