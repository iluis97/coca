package cn.luis.coca.dto.response;

import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;
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

    /**
     * 是否请求成功
     */
    private boolean success;
    private String code;
    private String desc;
    private T data;

    /**
     * 构造函数私有化
     */
    private ApiResponse() {
    }

    private ApiResponse(boolean success, ResponseCodeDescEnumAble responseCodeDesc, T data) {
        this.success = success;
        this.code = responseCodeDesc.getCode();
        this.desc = responseCodeDesc.getDesc();
        this.data = data;
    }

    private ApiResponse(boolean success, String code, String desc, T data) {
        this.success = success;
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, ResponseCodeDescEnumAble.respOk(), null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, ResponseCodeDescEnumAble.respOk(), data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, ResponseCodeDescEnumAble.OK, message, data);
    }

    public static <T> ApiResponse<T> successMessage(String message) {
        return new ApiResponse<>(true, ResponseCodeDescEnumAble.OK, message, null);
    }

    public static <T> ApiResponse<T> error(T data, String errorMessage) {
        return new ApiResponse<>(false, ResponseCodeDescEnumAble.FAIL, errorMessage, data);
    }

    public static <T> ApiResponse<T> errorMessage(String errorMessage) {
        return new ApiResponse<>(false, ResponseCodeDescEnumAble.FAIL, errorMessage, null);
    }

    public static <T> ApiResponse<T> errorMessage(ResponseCodeDescEnumAble responseCodeDesc) {
        return new ApiResponse<>(false, responseCodeDesc, null);
    }

}