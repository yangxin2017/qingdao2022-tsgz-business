package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("problem_diagnosis")
@ApiModel("网络诊断")
public class ProblemDiagnosis {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("开始时间")
    private String stime;
    @ApiModelProperty("结束时间")
    private String etime;
}
