package com.bgd.tsgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("com_info_tb")
@ApiModel("停车场")
public class ComInfoTb {
    @TableId(type= IdType.AUTO)
    //    id
    @ApiModelProperty("id")
    private String id;
    //    chanid
    @ApiModelProperty("chanid")
    private String chanid;
    //    company_id
    @ApiModelProperty("companyId")
    private String companyId;
    //    groupid
    @ApiModelProperty("groupid")
    private String groupid;
    //    park_name
    @ApiModelProperty("parkName")
    private String parkName;
    //    contacts
    @ApiModelProperty("contacts")
    private String contacts;
    //    phone
    @ApiModelProperty("phone")
    private String phone;
    //    address
    @ApiModelProperty("address")
    private String address;
    //    longitude
    @ApiModelProperty("longitude")
    private String longitude;
    //    latitude
    @ApiModelProperty("latitude")
    private String latitude;
    //    wgs_lng
    @ApiModelProperty("wgsLng")
    private String wgslng;
    //    wgs_lat
    @ApiModelProperty("wgsLat")
    private String wgslat;
    //    gcj_lng
    @ApiModelProperty("gcjLng")
    private String gcj_lng;
    //    gcj_lat
    @ApiModelProperty("gcjLat")
    private String gcjLat;
    //    coordinate_type
    @ApiModelProperty("coordinateType")
    private String coordinateType;
    //    create_time
    @ApiModelProperty("createTime")
    private String createTime;
    //    update_time
    @ApiModelProperty("updateTime")
    private String updateTime;
    //    park_type
    @ApiModelProperty("parkType")
    private String parkType;
    //    has_collector
    @ApiModelProperty("hasCollector")
    private String hasCollector;
    //    total
    @ApiModelProperty("total")
    private String total;
    //    charge_num
    @ApiModelProperty("chargeNum")
    private String chargeNum;
    //    state
    @ApiModelProperty("state")
    private String state;
    //    nofeel_pay
    @ApiModelProperty("nofeelPay")
    private String nofeelPay;
    //    book
    @ApiModelProperty("book")
    private String book;
    //    if_record
    @ApiModelProperty("if_record")
    private String if_record;
    //    coupon_on
    @ApiModelProperty("coupon_on")
    private String coupon_on;
    //    view_type
    @ApiModelProperty("view_type")
    private String view_type;
    //    remarks
    @ApiModelProperty("remarks")
    private String remarks;
    //    park_uuid
    @ApiModelProperty("parkUuid")
    private String parkUuid;
    //    area_code
    @ApiModelProperty("areaCode")
    private Integer areaCode;
    //    street_code
    @ApiModelProperty("streetCode")
    private String streetCode;
    //    community_code
    @ApiModelProperty("communityCode")
    private String communityCode;
    //    brigade_code
    @ApiModelProperty("brigadeCode")
    private String brigadeCode;
    //    city_code
    @ApiModelProperty("cityCode")
    private String cityCode;
    //    "empty"
    @ApiModelProperty("empty")
    private String empty;
    //    expense_type_id
    @ApiModelProperty("expenseTypeId")
    private String expenseTypeId;
    //    expense_rule
    @ApiModelProperty("expenseRule")
    private String expenseRule;
    //    rule_desc
    @ApiModelProperty("ruleDesc")
    private String ruleDesc;
    //    heart_time
    @ApiModelProperty("heartTime")
    private String heartTime;
    //    if_fee
    @ApiModelProperty("ifFee")
    private String ifFee;
    //    fee_standard
    @ApiModelProperty("feeStandard")
    private String feeStandard;
    //    if_online_pay
    @ApiModelProperty("ifOnlinePay")
    private String ifOnlinePay;
    //    is_invoice
    @ApiModelProperty("isInvoice")
    private String isInvoice;
    //    is_prepay
    @ApiModelProperty("isPrepay")
    private String isPrepay;
    //    park_source
    @ApiModelProperty("parkSource")
    private String parkSource;
    //    equip_type
    @ApiModelProperty("equipType")
    private String equipType;
    //    data_upload
    @ApiModelProperty("dataUpload")
    private String dataUpload;
    //    right_unit
    @ApiModelProperty("rightUnit")
    private String rightUnit;
    //    inside_road_area_id
    @ApiModelProperty("insideRoadAreaId")
    private String insideRoadAreaId;
    //    business_time_desc
    @ApiModelProperty("businessTimeDesc")
    private String businessTimeDesc;
    //    in_out_channel_num
    @ApiModelProperty("inOutChannelNum")
    private String inOutChannelNum;
    //    road_gate_brand
    @ApiModelProperty("roadGateBrand")
    private String roadGateBrand;

}
