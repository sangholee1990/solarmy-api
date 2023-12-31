package solarmy.front.vo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String message;
    private Object data;

    public Message() {
        this.data = null;
        this.message = null;
    }
}
