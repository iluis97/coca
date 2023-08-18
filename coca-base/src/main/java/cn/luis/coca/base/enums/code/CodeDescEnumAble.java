package cn.luis.coca.base.enums.code;

/**
 * 代码、描述枚举类接口
 *
 * @author luis
 * @since 1.0
 * 2022/10/6 21:55
 */
public interface CodeDescEnumAble extends CodeEnumAble {

    /**
     * 获取枚举描述
     *
     * @return desc
     */
    String getDesc();
}
