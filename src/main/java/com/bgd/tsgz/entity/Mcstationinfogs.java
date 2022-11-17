package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("mcstationinfogs")
@ApiModel("公交站")
public class Mcstationinfogs {
    @TableId(type= IdType.AUTO)
//    stationid
    @ApiModelProperty("站点id")
    private String stationid;
//    stationno
    @ApiModelProperty("站点编号")
    private String stationno;
//    stationname
    @ApiModelProperty("站点名")
    private String stationname;
//    aliasname
    @ApiModelProperty("别名")
    private String aliasname;
//    longitude
    @ApiModelProperty("经度")
    private String longitude;
//    latitude
    @ApiModelProperty("纬度")
    private String latitude;
//    stationposition
    @ApiModelProperty("站点位置")
    private String stationposition;
//    regionlevel
    @ApiModelProperty("区域级别")
    private String regionlevel;
//    regionarea
    @ApiModelProperty("区域面积")
    private String regionarea;
//    haseleboard
    @ApiModelProperty("是否有电子屏")
    private String haseleboard;
//    haswaitingboisk
    @ApiModelProperty("是否有候车亭")
    private String haswaitingboisk;
//    ishangestation
    @ApiModelProperty("是否是换乘站")
    private String ishangestation;
//    isfleetstation
    @ApiModelProperty("是否是车队站")
    private String isfleetstation;
//    fleetstationbuscount
    @ApiModelProperty("车队站车辆数")
    private String fleetstationbuscount;
//    ismainfleetstation
    @ApiModelProperty("是否是主车队站")
    private String ismainfleetstation;
//    stationlength
    @ApiModelProperty("站点长度")
    private String stationlength;
//    isactive
    @ApiModelProperty("是否有效")
    private String isactive;
//    memos
    @ApiModelProperty("备注")
    private String memos;
//    created
    @ApiModelProperty("创建时间")
    private Date created;
//    createdby
    @ApiModelProperty("创建人")
    private String createdby;
//    updated
    @ApiModelProperty("更新时间")
    private Date updated;
//    updatedby
    @ApiModelProperty("更新人")
    private String updatedby;
//    upszstationid
    @ApiModelProperty("上站点id")
    private String upszstationid;
//    upszstationidtmp
    @ApiModelProperty("上站点id临时")
    private String upszstationidtmp;
//    stationtype
    @ApiModelProperty("站点类型")
    private String stationtype;
//    routeids
    @ApiModelProperty("线路id")
    private String routeids;
//    routenames
    @ApiModelProperty("线路名")
    private String routenames;
//    isbrt
    @ApiModelProperty("是否是BRT")
    private String isbrt;
//    checkedstatus
    @ApiModelProperty("审核状态")
    private String checkedstatus;
//    approvalopinion
    @ApiModelProperty("审核意见")
    private String approvalopinion;
//    isapprove
    @ApiModelProperty("是否审核")
    private String isapprove;
//    lightbox_count
    @ApiModelProperty("灯箱数量")
    private String lightbox_count;
//    advertisement_count
    @ApiModelProperty("广告数量")
    private String advertisement_count;
//    stationcode
    @ApiModelProperty("站点编码")
    private String stationcode;
//    stationstatus
    @ApiModelProperty("站点状态")
    private String stationstatus;
//    roadid
    @ApiModelProperty("道路id")
    private String roadid;
//    direction
    @ApiModelProperty("方向")
    private String direction;
//    longitudeoffset
    @ApiModelProperty("经度偏移")
    private String longitudeoffset;
//    latitudeoffset
    @ApiModelProperty("纬度偏移")
    private String latitudeoffset;
//    longitudetrue
    @ApiModelProperty("真实经度")
    private String longitudetrue;
//    latitudetrue
    @ApiModelProperty("真实纬度")
    private String latitudetrue;
//    audit_id
    @ApiModelProperty("审核id")
    private String audit_id;
//    advertisementcount
    @ApiModelProperty("广告数量")
    private String advertisementcount;
//    lightboxcount
    @ApiModelProperty("灯箱数量")
    private String lightboxcount;
//    stationfacilitystyle
    @ApiModelProperty("站点设施风格")
    private String stationfacilitystyle;
//    stationlocaltype1
    @ApiModelProperty("站点位置类型1")
    private String stationlocaltype1;
//    stationlocaltype2
    @ApiModelProperty("站点位置类型2")
    private String stationlocaltype2;
//    stationlocaltype3
    @ApiModelProperty("站点位置类型3")
    private String stationlocaltype3;
//    stationlocaltype4
    @ApiModelProperty("站点位置类型4")
    private String stationlocaltype4;
//    stationlocaltype5
    @ApiModelProperty("站点位置类型5")
    private String stationlocaltype5;
//    stationlocaltype6
    @ApiModelProperty("站点位置类型6")
    private String stationlocaltype6;
//    stationlocaltype7
    @ApiModelProperty("站点位置类型7")
    private String stationlocaltype7;
//    stationlocaltype8
    @ApiModelProperty("站点位置类型8")
    private String stationlocaltype8;
//    stationlocaltype9
    @ApiModelProperty("站点位置类型9")
    private String stationlocaltype9;
//    stationlocaltype10
    @ApiModelProperty("站点位置类型10")
    private String stationlocaltype10;
//    stationpicture
    @ApiModelProperty("站点图片")
    private String stationpicture;
//    reserve1
    @ApiModelProperty("预留字段1")
    private String reserve1;
//    reserve2
    @ApiModelProperty("预留字段2")
    private String reserve2;
//    reserve3
    @ApiModelProperty("预留字段3")
    private String reserve3;
//    changetype
    @ApiModelProperty("变更类型")
    private String changetype;
//    activestartdate
    @ApiModelProperty("有效开始时间")
    private Date activestartdate;
//    activeenddate
    @ApiModelProperty("有效结束时间")
    private Date activeenddate;
//    activeflag
    @ApiModelProperty("有效标志")
    private String activeflag;
//    id
    @ApiModelProperty("id")
    private String id;
//    trafficzoneid
    @ApiModelProperty("交通区域id")
    private String trafficzoneid;
//    gridregionid
    @ApiModelProperty("网格区域id")
    private String gridregionid;
//    tradareaid
    @ApiModelProperty("商圈区域id")
    private String tradareaid;
//    realjd
    @ApiModelProperty("真实经度")
    private String realjd;
//    realwd
    @ApiModelProperty("真实纬度")
    private String realwd;
//    uploadfile
    @ApiModelProperty("上传文件")
    private String uploadfile;
//    isgatestation
    @ApiModelProperty("是否是出入口站点")
    private String isgatestation;

}
