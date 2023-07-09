package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InputDataVO {
    @ApiModelProperty(value = "제품 시리얼 번호", required = true)
    private String product_serial_number;

    private float temp;
    private float hmdty;
    private float pm25;
    private float pm10;
    private String mvmnt;
    private float tvoc;
    private float hcho;
    private float co2;
    private float co;
    private float benzo;
    private float radon;
    private String mod_date;
    private String reg_date;
    private float tmp;
    private float tmp2;
    private float tmp3;
    private float tmp4;
    private float tmp5;
    private String tmp6;
    private String tmp7;
    private String tmp8;
    private String tmp9;
    private String tmp10;
    //    private String date_time;
//    private String date;
//    private String time;

    @ApiModelProperty(value = "시작 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String srt_date_time;

    @ApiModelProperty(value = "종료 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String end_date_time;
}
