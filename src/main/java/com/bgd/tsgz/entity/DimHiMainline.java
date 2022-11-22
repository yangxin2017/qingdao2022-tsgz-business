package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("dim_hi_mainline")
@ApiModel("干线")
public class DimHiMainline {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("干线编号")
    private String mainlineid;

    @ApiModelProperty("干线名称")
    private String mainlinename;

    @ApiModelProperty("全长")
    private String fulllen;

    @ApiModelProperty("上行道口编号")
    private String upcrossingcode;

    @ApiModelProperty("下行道口编号")
    private String downcrossingcode;

    @ApiModelProperty("干线通用类型")
    private String mainlinecommontype;

    @ApiModelProperty("更新时间")
    private Date updatetime;

    @ApiModelProperty("失效时间")
    private Date expirationtime;

    @ApiModelProperty("是否有效")
    private String iseffect;

    @ApiModelProperty("来源")
    private String source;


}
