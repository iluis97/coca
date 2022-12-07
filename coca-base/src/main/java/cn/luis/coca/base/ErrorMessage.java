package cn.luis.coca.base;

import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;

/**
 * 目前仅做coca内部使用 [exception | response]
 *
 * @author luis
 */
@Getter
public final class ErrorMessage implements CodeDescEnumAble {

    private static final String OK = "200";
    private static final String FAIL = "5000";
    private static final String MESSAGE_OK = "操作成功";

    /**
     * 按理说不应该被使用哦,每个错误都应该有详尽说明！
     */
    private static final String MESSAGE_FAIL = "系统执行出错";

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

    public static ErrorMessage success() {
        return new ErrorMessage(OK, MESSAGE_OK);
    }

    public static ErrorMessage successMessage(String message) {
        return new ErrorMessage(OK, message);
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