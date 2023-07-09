package solarmy.front.vo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorVO {
    private String code;
    private String message;

    public ErrorVO() {
        this.code = code;
        this.message = "ERROR";
    }
}
