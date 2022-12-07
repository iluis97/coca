package cn.luis.coca.base.enums.value;

/**
 * 包含 name、value 的枚举
 *
 * @author luis
 * @since 1.0
 * created 2022/2/28 10:14
 */
public interface NameValueEnumAble<V> extends ValueEnumAble<V> {

    /**
     * 获取枚举名称
     *
     * @return 枚举名
     */
    String getName();
}