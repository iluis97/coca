package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;
import lombok.Getter;

/**
 * 基础自定义异常 [不引入具体的CodeDescEnum，只引入默认实现ErrorMessage] 不对外提供
 *
 * @author luis
 * @since 1.0
 * created 2022/2/17 9:35
 */
@Getter
class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6462976541406465434L;

    private final CodeDescEnumAble codeDescEnum;

    protected BaseException(Exception ex) {
        super(ex.getMessage(), ex);
        this.codeDescEnum = ErrorMessage.defaultError();
    }

    protected BaseException(ErrorMessage errorMessage) {
        super(errorMessage.getDesc());
        this.codeDescEnum = errorMessage;
    }

    protected BaseException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage.getDesc(), cause);
        this.codeDescEnum = errorMessage;
    }

    protected BaseException(CodeDescEnumAble codeDescEnum) {
        super(codeDescEnum.getDesc());
        this.codeDescEnum = codeDescEnum;
    }

    protected BaseException(CodeDescEnumAble codeDescEnum, Throwable cause) {
        super(codeDescEnum.getDesc(), cause);
        this.codeDescEnum = codeDescEnum;
    }

}