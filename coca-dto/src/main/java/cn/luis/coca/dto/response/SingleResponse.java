package cn.luis.coca.dto.response;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;
import lombok.ToString;

/**
 * 一个返回结果
 *
 * @author luis
 */
@Getter
@ToString
public class SingleResponse<T> {

    private static final long serialVersionUID = 1L;

    private T data;
    private boolean success;
    private String code;
    private String desc;

    /**
     * 构造函数私有化
     */
    private SingleResponse() {
    }

    private SingleResponse(boolean success, ErrorMessage errorMessage, T data) {
        this.success = success;
        this.code = errorMessage.getCode();
        this.desc = errorMessage.getDesc();
        this.data = data;
    }

    private SingleResponse(boolean success, CodeDescEnumAble codeDescEnum, T data) {
        this.success = success;
        this.code = codeDescEnum.getCode();
        this.desc = codeDescEnum.getDesc();
        this.data = data;
    }

    public static <T> SingleResponse<T> success() {
        return new SingleResponse<>(true, ErrorMessage.success(), null);
    }

    public static <T> SingleResponse<T> success(T data) {
        return new SingleResponse<>(true, ErrorMessage.success(), data);
    }

    public static <T> SingleResponse<T> success(T data, String message) {
        return new SingleResponse<>(true, ErrorMessage.successMessage(message), data);
    }

    public static <T> SingleResponse<T> successMessage(String message) {
        return new SingleResponse<>(true, ErrorMessage.successMessage(message), null);
    }

    public static SingleResponse<Void> errorMessage(String errMessage) {
        return new SingleResponse<>(false, ErrorMessage.errorOfMessage(errMessage), null);
    }

    public static SingleResponse<Void> errorMessage(CodeDescEnumAble codeDescEnum) {
        return new SingleResponse<>(false, codeDescEnum, null);
    }
}
