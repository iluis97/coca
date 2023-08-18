package cn.luis.coca.exception;

import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;
import lombok.Getter;

/**
 * 基础自定义异常 [不引入具体的CodeDescEnum，只引入默认实现ErrorMessage] 不对外提供
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
@Getter
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6462976541406465434L;

    protected final ResponseCodeDescEnumAble responseCodeDesc;

    protected BaseException(RuntimeException ex) {
        super(ex.getMessage(), ex);
        this.responseCodeDesc = ResponseCodeDescEnumAble.respFail();
    }

    protected BaseException(ResponseCodeDescEnumAble responseCodeDesc) {
        super(responseCodeDesc.getDesc());
        this.responseCodeDesc = responseCodeDesc;
    }

    protected BaseException(ResponseCodeDescEnumAble responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc.getDesc(), ex);
        this.responseCodeDesc = responseCodeDesc;
    }

}