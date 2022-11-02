package com.bgd.tsgz.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_section")
@ApiModel("重点路段")
public class ViewSection {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("阈值")
    private String threshold;
    @ApiModelProperty("gis")
    private String gis;
}
