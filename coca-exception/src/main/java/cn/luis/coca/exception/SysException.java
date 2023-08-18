package cn.luis.coca.exception;

import cn.luis.coca.base.enums.AliErrorCodeDescEnum;
import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;

/**
 * 系统异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = -6462976541406465434L;

    protected SysException(RuntimeException ex) {
        super(AliErrorCodeDescEnum.SYSTEM_ERROR_B0001, ex);
    }

    protected SysException(ResponseCodeDescEnumAble responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected SysException(ResponseCodeDescEnumAble responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}