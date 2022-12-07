package cn.luis.coca.base.enums.time;

import cn.luis.coca.base.constant.time.Hms;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum HmsEnum {

    HHmmss(Hms.HHmmss, Hms.formatter_HHmmss),
    HHmmssSSS(Hms.HHmmssSSS, Hms.formatter_HHmmssSSS);

    private final String content;
    private final DateTimeFormatter formatter;
}