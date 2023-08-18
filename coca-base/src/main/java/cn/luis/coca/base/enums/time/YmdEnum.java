package cn.luis.coca.base.enums.time;

import cn.luis.coca.base.constant.time.Ymd;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum YmdEnum {

    yyyyMMdd(Ymd.yyyyMMdd, Ymd.formatter_yyyyMMdd),
    yyyy_MM_dd(Ymd.yyyy_MM_dd, Ymd.formatter_yyyy_MM_dd),
    yyyy__MM__dd(Ymd.yyyy__MM__dd, Ymd.formatter_yyyy__MM__dd),
    yyyy_MM(Ymd.yyyy_MM, Ymd.formatter_yyyy_MM),
    yyyyMM(Ymd.yyyyMM, Ymd.formatter_yyyyMM);

    private final String content;
    private final DateTimeFormatter formatter;
}