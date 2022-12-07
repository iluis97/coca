package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;

/**
 * 业务异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 7456374730637231141L;

    protected BizException(Exception ex) {
        super(ex);
    }

    protected BizException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    protected BizException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    protected BizException(CodeDescEnumAble codeDescEnum) {
        super(codeDescEnum);
    }

    protected BizException(CodeDescEnumAble codeDescEnum, Throwable cause) {
        super(codeDescEnum, cause);
    }

}