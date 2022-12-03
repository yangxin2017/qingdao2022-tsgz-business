package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("com_info_tb_accuracy")
@ApiModel("停车场")
public class ComInfoTbAccuracy {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("accuracy")
    private String accuracy;
    @ApiModelProperty("createtime")
    private String createtime;
}
