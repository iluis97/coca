package cn.luis.coca.base.enums.value;

/**
 * 只含value的枚举
 *
 * @author luis
 * @since 1.0
 * created 2022/2/28 9:43
 */
public interface ValueEnumAble<V> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    V getValue();

}