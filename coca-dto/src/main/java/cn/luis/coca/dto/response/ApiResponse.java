package cn.luis.coca.dto.response;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一返回(旧版)
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 8:59
 */
@Getter
@ToString
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 5508412906173429839L;

    private boolean success;
    private String code;
    private String desc;
    private T data;

    /**
     * 构造函数私有化
     */
    private ApiResponse() {
    }

    private ApiResponse(boolean success, ErrorMessage errorMessage, T data) {
        this.success = success;
        this.code = errorMessage.getCode();
        this.desc = errorMessage.getDesc();
        this.data = data;
    }

    private ApiResponse(boolean success, CodeDescEnumAble codeDescEnum, T data) {
        this.success = success;
        this.code = codeDescEnum.getCode();
        this.desc = codeDescEnum.getDesc();
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, ErrorMessage.success(), null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, ErrorMessage.success(), data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, ErrorMessage.successMessage(message), data);
    }

    public static <T> ApiResponse<T> successMessage(String message) {
        return new ApiResponse<>(true, ErrorMessage.successMessage(message), null);
    }

    public static <T> ApiResponse<T> errorMessage(String errorMessage) {
        return new ApiResponse<>(false, ErrorMessage.errorOfMessage(errorMessage), null);
    }

    public static <T> ApiResponse<T> errorMessage(CodeDescEnumAble codeDescEnum) {
        return new ApiResponse<>(false, codeDescEnum, null);
    }

}