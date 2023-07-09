package solarmy.front.vo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataVO {
    private int cnt;
    private Object list;

    public DataVO() {
        this.cnt = cnt;
        this.list = list;
    }
}
