package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_forecast")
@ApiModel("交通路况预测")
public class ViewForecast {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("位置")
    private String position;
    @ApiModelProperty("交通量")
    private String trafficVolum;
    @ApiModelProperty("时间")
    private String time;
    @ApiModelProperty("预测id")
    private String forecastid;
    @ApiModelProperty("路段编码")
    private String sectionCode;
    @ApiModelProperty("路段名称")
    private String sectionName;
    @ApiModelProperty("区域编码")
    private String areaCode;

}
