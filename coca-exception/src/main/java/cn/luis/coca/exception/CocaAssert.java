package cn.luis.coca.exception;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author lzw
 */
public final class CocaAssert {
    private CocaAssert() {
    }

    public static void isTrue(boolean expression, String errMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void isFalse(boolean expression, String errMessage) {
        if (expression) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] Must be true");
    }

    public static void isFalse(boolean expression) {
        isFalse(expression, "[Assertion failed] Must be false");
    }

    public static void notNull(Object object, String errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void notBlank(String content, String errMessage) {
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] Must not null");
    }

    public static void notEmpty(Collection<?> collection, String errMessage) {
        if (collection == null || collection.size() <= 0) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] Collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String errMessage) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] Map must not be empty: it must contain at least one entry");
    }
}