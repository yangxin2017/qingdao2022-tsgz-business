package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("bis_area_section")
@ApiModel("对应路段")
public class BisAreaSection {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("区域id")
    private String areaid;
    @ApiModelProperty("路段编号")
    private String sectioncode;
    @ApiModelProperty("更新时间")
    private Date updatetime;
    @ApiModelProperty("失效时间")
    private Date expirationtime;
    @ApiModelProperty("是否有效")
    private String iseffect;
    @ApiModelProperty("来源")
    private String source;
    @ApiModelProperty("是否重点")
    private String keyflag;
}
