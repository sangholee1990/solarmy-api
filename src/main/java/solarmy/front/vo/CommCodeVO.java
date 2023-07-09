package solarmy.front.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CommCodeVO {
    @ApiModelProperty(value = "코드", required = false)
    private String code;

    private String name;
    private String use_yn;
    private String mod_date;
    private String reg_date;
}
