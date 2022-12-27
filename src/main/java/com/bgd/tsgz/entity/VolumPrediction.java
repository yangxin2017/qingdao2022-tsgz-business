package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("volum_prediction")
@ApiModel("交通预测")
public class VolumPrediction {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("模型名称")
    private String modelName;
    @ApiModelProperty("路段编码")
    private String cintsid;
    @ApiModelProperty("执行时间")
    private String excuteTime;
    @ApiModelProperty("预测时间")
    private String futureTime;
    @ApiModelProperty("交通量")
    private String volum;


}
