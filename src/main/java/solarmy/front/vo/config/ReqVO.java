package solarmy.front.vo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqVO {
    private String srv;
    private Object var;

    public ReqVO() {
        this.srv = srv;
        this.var = var;
    }
}
