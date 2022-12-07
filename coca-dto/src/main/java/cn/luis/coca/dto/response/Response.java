package cn.luis.coca.dto.response;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 无 data 返回格式
 *
 * @author luis
 */
@Getter
@ToString
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String code;
    private String desc;

    private Response() {
    }

    private Response(boolean success, ErrorMessage errorMessage) {
        this.success = success;
        this.code = errorMessage.getCode();
        this.desc = errorMessage.getDesc();
    }

    private Response(boolean success, CodeDescEnumAble codeDescEnum) {
        this.success = success;
        this.code = codeDescEnum.getCode();
        this.desc = codeDescEnum.getDesc();
    }

    public static Response success() {
        return new Response(true, ErrorMessage.success());
    }

    public static Response successMessage(String message) {
        return new Response(true, ErrorMessage.successMessage(message));
    }

    public static Response errorMessage(String errMessage) {
        return new Response(false, ErrorMessage.errorOfMessage(errMessage));
    }

    public static Response errorMessage(CodeDescEnumAble codeDescEnum) {
        return new Response(false, codeDescEnum);
    }

}