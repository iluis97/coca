package cn.luis.coca.exception;

import cn.luis.coca.base.ErrorMessage;
import cn.luis.coca.base.enums.code.CodeDescEnumAble;

/**
 * 异常工厂实现、统一管理
 *
 * @author luis
 * @since 1.0
 * created 2022/5/28 12:03
 */
public class ExceptionFactory {

    /**
     * thirdPartException
     */
    public static ThirdPartException thirdPartException(Exception ex) {
        return new ThirdPartException(ex);
    }

    public static ThirdPartException thirdPartException(String message) {
        return new ThirdPartException(ErrorMessage.errorOfMessage(message));
    }

    public static ThirdPartException thirdPartException(String message, Exception ex) {
        return new ThirdPartException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static ThirdPartException thirdPartException(CodeDescEnumAble codeDescEnum) {
        return new ThirdPartException(codeDescEnum);
    }

    public static ThirdPartException thirdPartException(CodeDescEnumAble codeDescEnum, Exception ex) {
        return new ThirdPartException(codeDescEnum, ex);
    }

    /**
     * userException
     */
    public static UserException userException(Exception ex) {
        return new UserException(ex);
    }

    public static UserException userException(String message) {
        return new UserException(ErrorMessage.errorOfMessage(message));
    }

    public static UserException userException(String message, Exception ex) {
        return new UserException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static UserException userException(CodeDescEnumAble codeDescEnum) {
        return new UserException(codeDescEnum);
    }

    public static UserException userException(CodeDescEnumAble codeDescEnum, Exception ex) {
        return new UserException(codeDescEnum, ex);
    }


    /**
     * bizException
     */
    public static BizException bizException(Exception ex) {
        return new BizException(ex);
    }

    public static BizException bizException(String message) {
        return new BizException(ErrorMessage.errorOfMessage(message));
    }

    public static BizException bizException(String message, Exception ex) {
        return new BizException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static BizException bizException(CodeDescEnumAble codeDescEnum) {
        return new BizException(codeDescEnum);
    }

    public static BizException bizException(CodeDescEnumAble codeDescEnum, Exception ex) {
        return new BizException(codeDescEnum, ex);
    }

    /**
     * sysException
     */
    public static SysException sysException(Exception ex) {
        return new SysException(ex);
    }

    public static SysException sysException(String message) {
        return new SysException(ErrorMessage.errorOfMessage(message));
    }

    public static SysException sysException(String message, Exception ex) {
        return new SysException(ErrorMessage.errorOfMessage(message), ex);
    }

    public static SysException sysException(CodeDescEnumAble codeDescEnum) {
        return new SysException(codeDescEnum);
    }

    public static SysException sysException(CodeDescEnumAble codeDescEnum, Exception ex) {
        return new SysException(codeDescEnum, ex);
    }

}