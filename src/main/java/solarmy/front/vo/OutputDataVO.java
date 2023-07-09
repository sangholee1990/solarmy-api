package solarmy.front.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OutputDataVO {

    @ApiModelProperty(value = "고객 연동 번호", required = true)
    private Integer customer_link_number;

    @ApiModelProperty(value = "시작 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String srt_date_time;

    @ApiModelProperty(value = "종료 시간 (%Y-%m-%d %H:%M:%S)", required = true)
    private String end_date_time;

    private float temp;
    private float hmdty;
    private float pm25;
    private float pm10;
    private float dust;
    private float co2;
    private float pwr;
    private float gas;
    private float water;
    private float prd_pwr;
    private float prd_gas;
    private float prd_water;
    private String mod_date;
    private String reg_date;
    //    private String date_time;
//    private String date;
//    private String time;
}
