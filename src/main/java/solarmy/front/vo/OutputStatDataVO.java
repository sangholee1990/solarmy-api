package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OutputStatDataVO {
    @ApiModelProperty(value = "고객 연동 번호", required = true)
    private Integer customer_link_number;

    @ApiModelProperty(value = "시작 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String srt_date_time;

    @ApiModelProperty(value = "종료 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String end_date_time;

    private float prv_pwr;
    private float prv_gas;
    private float prv_water;
    private float prd_prv_pwr;
    private float prd_prv_gas;
    private float prd_prv_water;
    private float pre_pwr;
    private float pre_gas;
    private float pre_water;
    private float prd_pre_pwr;
    private float prd_pre_gas;
    private float prd_pre_water;
    private String mod_date;
    private String reg_date;
    //    private String date_time;
//    private String date;
//    private String time;
}
