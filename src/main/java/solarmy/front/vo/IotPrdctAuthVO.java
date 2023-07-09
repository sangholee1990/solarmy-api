package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class IotPrdctAuthVO {
    @ApiModelProperty(value = "제품 시리얼 번호", required = true)
    private String product_serial_number;

    private String auth_yn;
    private String use_yn;
    private String mod_date;
    private String reg_date;
}
