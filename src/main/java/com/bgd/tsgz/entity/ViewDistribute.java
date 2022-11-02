package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_distribute")
@ApiModel("职住分布")
public class ViewDistribute {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("数值")
    private String value;

    @ApiModelProperty("阈值")
    private String threshold;

    @ApiModelProperty("起始经度")
    private String slng;
    @ApiModelProperty("起始纬度")
    private String slat;
    @ApiModelProperty("结束经度")
    private String elng;
    @ApiModelProperty("结束纬度")
    private String elat;


}
