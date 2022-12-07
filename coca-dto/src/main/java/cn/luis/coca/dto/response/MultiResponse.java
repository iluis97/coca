package cn.luis.coca.dto.response;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 集合响应结果
 *
 * @author luis
 */
@Getter
@ToString
public class MultiResponse<T> {

    private static final long serialVersionUID = 1L;

    private Collection<T> data;
    private boolean success;
    private String code;
    private String desc;

    /**
     * 构造函数私有化
     */
    private MultiResponse() {
    }

    private MultiResponse(boolean success, ErrorMessage errorMessage, Collection<T> data) {
        this.success = success;
        this.code = errorMessage.getCode();
        this.desc = errorMessage.getDesc();
        this.data = formatData(data);
    }

    private MultiResponse(boolean success, CodeDescEnumAble codeDescEnum, Collection<T> data) {
        this.success = success;
        this.code = codeDescEnum.getCode();
        this.desc = codeDescEnum.getDesc();
        this.data = formatData(data);
    }

    public static <T> MultiResponse<T> success() {
        return new MultiResponse<>(true, ErrorMessage.success(), null);
    }

    public static <T> MultiResponse<T> success(Collection<T> data) {
        return new MultiResponse<>(true, ErrorMessage.success(), data);
    }

    public static <T> MultiResponse<T> success(Collection<T> data, String message) {
        return new MultiResponse<>(true, ErrorMessage.successMessage(message), data);
    }

    public static <T> MultiResponse<T> successMessage(String message) {
        return new MultiResponse<>(true, ErrorMessage.successMessage(message), null);
    }

    public static MultiResponse<Void> errorMessage(String errMessage) {
        return new MultiResponse<>(false, ErrorMessage.errorOfMessage(errMessage), null);
    }

    public static MultiResponse<Void> errorMessage(CodeDescEnumAble codeDescEnum) {
        return new MultiResponse<>(false, codeDescEnum, null);
    }

    public static <T> List<T> formatData(Collection<T> data) {
        return null == data ? Collections.emptyList() : new ArrayList<>(data);
    }

    public List<T> getData() {
        return formatData(this.data);
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

}
