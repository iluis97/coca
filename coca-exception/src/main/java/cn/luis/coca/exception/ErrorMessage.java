package cn.luis.coca.exception;

import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;
import lombok.Getter;

/**
 * 目前仅做coca内部使用
 *
 * @author luis
 */
@Getter
public final class ErrorMessage implements ResponseCodeDescEnumAble {

    private String code;
    private String desc;

    private ErrorMessage() {
    }

    /**
     * 不允许暴露，如果随处定义errorCode，那将是场灾难
     *
     * @param code 错误码
     * @param desc 错误信息
     */
    private ErrorMessage(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 虽然但是，不建议你使用 [用作系统默认错误提示]
     */
    public static ErrorMessage defaultError() {
        return new ErrorMessage(FAIL, MESSAGE_FAIL);
    }

    public static ErrorMessage errorOfMessage(String errorMessage) {
        return new ErrorMessage(FAIL, errorMessage);
    }

    @Override
    public String toString() {
        return "ErrorMessage(errorCode=" + this.getCode() + ", errorMessage=" + this.getDesc() + ")";
    }
}