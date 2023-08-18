package cn.luis.coca.exception;

import cn.luis.coca.base.enums.AliErrorCodeDescEnum;
import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;

/**
 * 第三方异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class ThirdPartException extends BaseException {

    private static final long serialVersionUID = 7456374730637231241L;

    protected ThirdPartException(RuntimeException ex) {
        super(AliErrorCodeDescEnum.SERVICE_ERROR_C0001, ex);
    }

    protected ThirdPartException(ResponseCodeDescEnumAble responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected ThirdPartException(ResponseCodeDescEnumAble responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}