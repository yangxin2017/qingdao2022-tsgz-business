package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("日志")
public class LogVo {
    private String sysName;
    private String saveDate;
    private String logType;
    private String moduleName;
    private String functionName;
    private String logCode;
    private String userName;
    private String userId;
    private String operateIp;
    private String operateResult;
    private String errorCode;
    private String description;
}
