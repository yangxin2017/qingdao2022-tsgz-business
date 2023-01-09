package com.bgd.tsgz.entity;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;


@Data
@TableName("view_acf_details")
@ApiModel("事故详情列表")
public class ViewAcfDetails {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("事故时间")
    private Date time;
    @ApiModelProperty("事故类型")
    private String type;
    @ApiModelProperty("事故来源")
    private String source;
    @ApiModelProperty("事故地址")
    private String address;
    @ApiModelProperty("所属单位")
    private String belonging;
    @ApiModelProperty("事故描述")
    private String describe;
    @ApiModelProperty("报警")
    private String callThePolice;
    @ApiModelProperty("确认报警")
    private String confirm;
    @ApiModelProperty("派警")
    private String dispatchPolice;
    @ApiModelProperty("报警关闭")
    private String closingTheAlarm;
    @ApiModelProperty("视频")
    private String video;
    @ApiModelProperty("位置")
    private String position;
    
}
