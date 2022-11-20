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
    // gis, traffic_volum, "time", forecastid, section_code
    @ApiModelProperty("gis")
    private String gis;
    @ApiModelProperty("流量数据")
    private String trafficVolum;
    @ApiModelProperty("时间")
    private String time;
    @ApiModelProperty("预测id")
    private String forecastid;
    @ApiModelProperty("路段编码")
    private String sectionCode;
}
