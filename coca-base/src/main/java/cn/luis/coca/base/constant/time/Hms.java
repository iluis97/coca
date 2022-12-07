package cn.luis.coca.base.constant.time;

import java.time.format.DateTimeFormatter;

/**
 * 时分秒
 */
@SuppressWarnings("all")
public final class Hms {
    public static final String HHmmss = "HH:mm:ss";
    public static final String HHmmssSSS = "hhmmssSSS";

    public static final DateTimeFormatter formatter_HHmmss = DateTimeFormatter.ofPattern(HHmmss);
    public static final DateTimeFormatter formatter_HHmmssSSS = DateTimeFormatter.ofPattern(HHmmssSSS);

}