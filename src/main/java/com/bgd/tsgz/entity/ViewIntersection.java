package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("view_intersection")
@ApiModel("重点路口")
public class ViewIntersection {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("路口code")
    private String code;
}
