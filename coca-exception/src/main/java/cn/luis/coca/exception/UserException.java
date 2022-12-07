package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;

/**
 * 用户异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 7456374730637234141L;

    protected UserException(Exception ex) {
        super(ex);
    }

    protected UserException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    protected UserException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    protected UserException(CodeDescEnumAble codeDescEnum) {
        super(codeDescEnum);
    }

    protected UserException(CodeDescEnumAble codeDescEnum, Throwable cause) {
        super(codeDescEnum, cause);
    }

}