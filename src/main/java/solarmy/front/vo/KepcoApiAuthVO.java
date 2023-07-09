package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class KepcoApiAuthVO {
    @ApiModelProperty(value = "한전 고객 번호", required = true)
    private String kepco_api_key;

    private String auth_yn;
    private String use_yn;
    private String mod_date;
    private String reg_date;
}
