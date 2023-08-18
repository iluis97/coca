package cn.luis.coca.base.enums.code;

/**
 * 代码、描述枚举类接口
 *
 * @author luis
 * @since 1.0
 * 2022/10/6 21:55
 */
public interface ResponseCodeDescEnumAble extends CodeDescEnumAble {
    String OK = "200";
    String FAIL = "5000";
    String MESSAGE_OK = "操作成功";
    /**
     * 按理说不应该被使用哦,每个错误都应该有详尽说明！
     */
    String MESSAGE_FAIL = "系统执行出错";


    static ResponseCodeDescEnumAble respOk() {
        return new ResponseCodeDescEnumAble() {
            @Override
            public String getCode() {
                return OK;
            }

            @Override
            public String getDesc() {
                return MESSAGE_OK;
            }
        };
    }

    static ResponseCodeDescEnumAble respFail() {
        return new ResponseCodeDescEnumAble() {
            @Override
            public String getCode() {
                return FAIL;
            }

            @Override
            public String getDesc() {
                return MESSAGE_FAIL;
            }
        };
    }

}
