package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("volum_pedestrian_prediction")
@ApiModel("行人预测")
public class VolumPedestrianPrediction {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private String id;
    // cross_id, grid_longitude, grid_latitude, excute_time, future_time, grid_volum
    @ApiModelProperty("路口id")
    private String crossId;
    @ApiModelProperty("经度")
    private String gridLongitude;
    @ApiModelProperty("纬度")
    private String gridLatitude;
    @ApiModelProperty("执行时间")
    private String excuteTime;
    @ApiModelProperty("预测时间")
    private String futureTime;
    @ApiModelProperty("预测值")
    private String gridVolum;


}
