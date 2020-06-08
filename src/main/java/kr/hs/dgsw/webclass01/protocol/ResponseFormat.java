package kr.hs.dgsw.webclass01.protocol;

import lombok.Data;

@Data // getter, setter set
public class ResponseFormat {
    private int code;
    private String desc;
    private Object data;

    public ResponseFormat(ResponseType rt, Object data, Object option) {
        this.code = rt.code();
        this.desc = option instanceof Long || option instanceof String ? String.format(rt.desc(), option) : rt.desc();
        this.data = data;
    }

    public ResponseFormat(ResponseType rt, Object data) {
        this(rt, data, null);
    }
}
