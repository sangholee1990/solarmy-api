package solarmy.front.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MsgInfoVO {
    @ApiModelProperty(value = "메시지 코드", required = false)
    private String msg_code;

    private String msg_version;
    private String msg_cont;
    private String use_yn;
    private String mod_date;
    private String reg_date;
}
