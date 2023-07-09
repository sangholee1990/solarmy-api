package solarmy.front.vo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleResponse {
    private String code;
    private Object data;
    private Object req;

    public SampleResponse() {
        this.code = "00";
        this.data = data;
        this.req = req;
    }
}
