package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("view_induce")
@ApiModel("诱导")
public class ViewInduce {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("经度")
    private String lng;

    @ApiModelProperty("纬度")
    private String lat;

    @ApiModelProperty("型号")
    private String model;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("安装日期")
    private String installdata;

    @ApiModelProperty("第三方编号")
    private String thirdnumber;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("类型")
    private String type;
}
