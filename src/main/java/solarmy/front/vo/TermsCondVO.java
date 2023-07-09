package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TermsCondVO {
    @ApiModelProperty(value = "고객 연동 번호", required = true)
    private Integer customer_link_number;

    @ApiModelProperty(value = "약관 코드", required = false)
    private String terms_code;

    @ApiModelProperty(value = "약관 버전", required = false)
    private String terms_version;

    private String terms_cont;
    private String agrtr_cndtn_yn;
    private String use_yn;
    private String mod_date;
    private String reg_date;
}
