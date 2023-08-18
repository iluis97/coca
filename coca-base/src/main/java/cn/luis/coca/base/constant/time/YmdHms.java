package cn.luis.coca.base.constant.time;

import java.time.format.DateTimeFormatter;

/**
 * 年月日时分秒
 */
@SuppressWarnings("all")
public final class YmdHms {
    public static final String yyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddTHHmmssZ = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String yyyyMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";

    public static final DateTimeFormatter formatter_yyyy_MM_ddHHmmss = DateTimeFormatter.ofPattern(yyyy_MM_ddHHmmss);
    public static final DateTimeFormatter formatter_yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern(yyyyMMddHHmmssSSS);
    public static final DateTimeFormatter formatter_yyyyMMddHHmmss = DateTimeFormatter.ofPattern(yyyyMMddHHmmss);
    public static final DateTimeFormatter formatter_yyyyMMddTHHmmssZ = DateTimeFormatter.ofPattern(yyyyMMddTHHmmssZ);
    public static final DateTimeFormatter formatter_yyyyMMddTHHmmss = DateTimeFormatter.ofPattern(yyyyMMddTHHmmss);
}