package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;

/**
 * 第三方异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class ThirdPartException extends BaseException {

    private static final long serialVersionUID = 7456374730637231241L;

    protected ThirdPartException(Exception ex) {
        super(ex);
    }

    protected ThirdPartException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    protected ThirdPartException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    protected ThirdPartException(CodeDescEnumAble codeDescEnum) {
        super(codeDescEnum);
    }

    protected ThirdPartException(CodeDescEnumAble codeDescEnum, Throwable cause) {
        super(codeDescEnum, cause);
    }

}