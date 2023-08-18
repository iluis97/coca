package cn.luis.coca.exception;

import cn.luis.coca.base.enums.AliErrorCodeDescEnum;
import cn.luis.coca.base.enums.code.ResponseCodeDescEnumAble;

/**
 * 用户异常
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:34
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 7456374730637234141L;

    protected UserException(RuntimeException ex) {
        super(AliErrorCodeDescEnum.USER_ERROR_A0001, ex);
    }

    protected UserException(ResponseCodeDescEnumAble responseCodeDesc) {
        super(responseCodeDesc);
    }

    protected UserException(ResponseCodeDescEnumAble responseCodeDesc, RuntimeException ex) {
        super(responseCodeDesc, ex);
    }
}