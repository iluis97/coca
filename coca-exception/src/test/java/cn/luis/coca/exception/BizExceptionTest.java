package cn.luis.coca.exception;

/**
 * biz test
 *
 * @author luis
 * @since 1.0
 * 2022/10/7 23:35
 */
public class BizExceptionTest {

    public static void main(String[] args) {
        BizException bizException = new BizException(ErrorMessage.errorOfMessage("asd"));
        System.out.println(bizException.getCodeDescEnum().getCode());

        // throw new BizException(ErrorMessage.errorOfMessage("asd"));
        throw ExceptionFactory.bizException("asd");
    }

}
