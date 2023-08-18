package cn.luis.coca.base.constant.time;

import java.time.format.DateTimeFormatter;

/**
 * 年月日
 */
@SuppressWarnings("all")
public final class Ymd {
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy__MM__dd = "yyyy/MM/dd";
    public static final String yyyy_MM = "yyyy-MM";
    public static final String yyyyMM = "yyyyMM";

    public static final DateTimeFormatter formatter_yyyyMMdd = DateTimeFormatter.ofPattern(yyyyMMdd);
    public static final DateTimeFormatter formatter_yyyy_MM_dd = DateTimeFormatter.ofPattern(yyyy_MM_dd);
    public static final DateTimeFormatter formatter_yyyy__MM__dd = DateTimeFormatter.ofPattern(yyyy__MM__dd);

    public static final DateTimeFormatter formatter_yyyy_MM = DateTimeFormatter.ofPattern(yyyy_MM);
    public static final DateTimeFormatter formatter_yyyyMM = DateTimeFormatter.ofPattern(yyyyMM);


}