package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;

/**
 * 系统异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = -6462976541406465434L;

    protected SysException(Exception ex) {
        super(ex);
    }

    protected SysException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    protected SysException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    protected SysException(CodeDescEnumAble codeDescEnum) {
        super(codeDescEnum);
    }

    protected SysException(CodeDescEnumAble codeDescEnum, Throwable cause) {
        super(codeDescEnum, cause);
    }

}