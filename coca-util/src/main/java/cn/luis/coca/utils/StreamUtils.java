package cn.luis.coca.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Stream工具类
 *
 * @author Lius
 * @since 1.0
 * created 2022/6/7 14:02
 */
public final class StreamUtils {

    private StreamUtils() {
    }

    /**
     * 根据条件筛选数据
     *
     * @param data 原数据
     * @param p    布尔值函数
     */
    public static <T> List<T> filterAndCollect(List<T> data, Predicate<T> p) {
        if (data == null || data.isEmpty()) {
            return new ArrayList<>(0);
        }
        return data.stream()
                .filter(p)
                .collect(Collectors.toList());
    }

    /**
     * 通过指定关键字搭配filter去重，若传参是复杂类型，记得EqualsAndHashCode
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(2);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}