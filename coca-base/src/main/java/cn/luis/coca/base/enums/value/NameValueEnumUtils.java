package cn.luis.coca.base.enums.value;

/**
 * 特定枚举工具类
 *
 * @author luis
 * @since 1.0
 * created 2022/2/28 10:23
 */
public final class NameValueEnumUtils {

    private NameValueEnumUtils() {
    }

    /**
     * 判断值是否存在
     *
     * @param enumClass 目标枚举类
     * @param value     枚举类值
     * @param <E>       目标枚举类
     * @param <V>       枚举类值的类型
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<? extends ValueEnumAble<V>>, V> boolean valueIsExit(Class<E> enumClass, V value) {
        for (Enum<? extends ValueEnumAble<V>> enumConstant : enumClass.getEnumConstants()) {
            if (((ValueEnumAble<V>) enumConstant).getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 根据name获取枚举值
     *
     * @param enumClass 目标枚举类
     * @param name      枚举类名
     * @param <E>       目标枚举类
     * @param <V>       枚举类值的类型
     * @return value
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<? extends NameValueEnumAble<V>>, V> V getValue(Class<E> enumClass, String name) {
        for (Enum<? extends NameValueEnumAble<V>> enumConstant : enumClass.getEnumConstants()) {
            if (((NameValueEnumAble<V>) enumConstant).getName().equals(name)) {
                return ((NameValueEnumAble<V>) enumConstant).getValue();
            }
        }
        // 配合optional
        return null;
    }

}