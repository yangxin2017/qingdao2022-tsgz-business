package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("view_acf")
@ApiModel("事故")
public class ViewAcf {
    @TableId(type= IdType.AUTO)
    // "time", sgdd, sglx, jdwz
    @ApiModelProperty("事故时间")
    private String time;
    @ApiModelProperty("事故地点")
    private String sgdd;
    @ApiModelProperty("事故类型")
    private String sglx;
    @ApiModelProperty("绝对位置")
    private String jdwz;

    
    
}
