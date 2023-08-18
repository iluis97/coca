package cn.luis.coca.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * BigDecimal工具类
 *
 * @author Lius
 * @since 1.0
 * created 2022/3/11 9:09
 */
public final class BigDecimalUtils {
    public static final BigDecimal ZeroBigDecimal = new BigDecimal("0");
    public static final BigDecimal OneHundredBigDecimal = new BigDecimal("100");
    public static final int TWO_SCALE = 2;
    public static final int FIVE_SCALE = 5;
    public static final int TEN_SCALE = 10;

    private BigDecimalUtils() {
    }

    /**
     * 加法
     *
     * @param a 被除数
     * @param b 除数
     */
    public static BigDecimal add(String a, String b) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.add(bBigDecimal);
    }

    /**
     * 加法
     * 注意: nums为空返回null
     *
     * @param nums 被除数
     */
    public static BigDecimal add(String... nums) {
        return Arrays.stream(nums)
                .filter(StringUtils::isNotBlank)
                .map(BigDecimal::new)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new IllegalArgumentException("BigDecimal Error"));

    }

    /**
     * 减法
     *
     * @param a 被除数
     * @param b 除数
     */
    public static BigDecimal subtract(String a, String b) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.subtract(bBigDecimal);
    }

    /**
     * 减法
     * 注意: nums为空返回null
     *
     * @param nums 被除数
     */
    public static BigDecimal subtract(String... nums) {
        return Arrays.stream(nums)
                .filter(StringUtils::isNotBlank)
                .map(BigDecimal::new)
                .reduce(BigDecimal::subtract)
                .orElseThrow(() -> new IllegalArgumentException("BigDecimal Error"));

    }

    /**
     * 乘法
     *
     * @param a 被除数
     * @param b 除数
     */
    public static BigDecimal multiply(String a, String b) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.multiply(bBigDecimal);
    }

    /**
     * 乘法
     * 注意: nums为空返回null
     *
     * @param nums 被除数
     */
    public static BigDecimal multiply(String... nums) {
        return Arrays.stream(nums)
                .filter(StringUtils::isNotBlank)
                .map(BigDecimal::new)
                .reduce(BigDecimal::multiply)
                .orElseThrow(() -> new IllegalArgumentException("BigDecimal Error"));

    }

    /**
     * 除法
     * 通常使用 RoundingMode.HALF_UP 四舍五入
     *
     * @param a            被除数
     * @param b            除数
     * @param scale        保留几位小数
     * @param roundingMode 舍入模式 {@link java.math.RoundingMode}
     */
    public static BigDecimal divide(String a, String b, int scale, RoundingMode roundingMode) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.divide(bBigDecimal, scale, roundingMode);
    }

    /**
     * 除法 四舍五入
     *
     * @param a     被除数
     * @param b     除数
     * @param scale 保留几位小数
     */
    public static BigDecimal divideHalfUp(String a, String b, int scale) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.divide(bBigDecimal, scale, RoundingMode.HALF_UP);
    }

    /**
     * 除法
     * 通常使用 RoundingMode.HALF_UP 四舍五入
     *
     * @param aBigDecimal  被除数
     * @param b            除数
     * @param scale        保留几位小数
     * @param roundingMode 舍入模式 {@link java.math.RoundingMode}
     */
    public static BigDecimal divide(BigDecimal aBigDecimal, String b, int scale, RoundingMode roundingMode) {
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.divide(bBigDecimal, scale, roundingMode);
    }

    /**
     * 除法 四舍五入
     *
     * @param aBigDecimal 被除数
     * @param b           除数
     * @param scale       保留几位小数
     */
    public static BigDecimal divideHalfUp(BigDecimal aBigDecimal, String b, int scale) {
        BigDecimal bBigDecimal = new BigDecimal(b);
        return aBigDecimal.divide(bBigDecimal, scale, RoundingMode.HALF_UP);
    }

    /**
     * 除法
     * 通常使用 RoundingMode.HALF_UP 四舍五入
     *
     * @param a            被除数
     * @param bBigDecimal  除数
     * @param scale        保留几位小数
     * @param roundingMode 舍入模式 {@link java.math.RoundingMode}
     */
    public static BigDecimal divide(String a, BigDecimal bBigDecimal, int scale, RoundingMode roundingMode) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        return aBigDecimal.divide(bBigDecimal, scale, roundingMode);
    }

    /**
     * 除法 四舍五入
     *
     * @param a           被除数
     * @param bBigDecimal 除数
     * @param scale       保留几位小数
     */
    public static BigDecimal divideHalfUp(String a, BigDecimal bBigDecimal, int scale) {
        BigDecimal aBigDecimal = new BigDecimal(a);
        return aBigDecimal.divide(bBigDecimal, scale, RoundingMode.HALF_UP);
    }

    /**
     * 除法
     * 通常使用 RoundingMode.HALF_UP 四舍五入
     *
     * @param aBigDecimal  被除数
     * @param bBigDecimal  除数
     * @param scale        保留几位小数
     * @param roundingMode 舍入模式 {@link java.math.RoundingMode}
     */
    public static BigDecimal divide(BigDecimal aBigDecimal, BigDecimal bBigDecimal, int scale, RoundingMode roundingMode) {
        return aBigDecimal.divide(bBigDecimal, scale, roundingMode);
    }

}