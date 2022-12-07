package cn.luis.coca.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @author lzw
 */
public final class LocalDateTimeUtils {

    private final static ZoneId zone = ZoneId.systemDefault();

    private LocalDateTimeUtils() {
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date localDateToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date localTimeToDate(LocalTime localTime) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static long betweenDays(Date date1, Date date2) {
        LocalDateTime localDateTime1 = dateToLocalDateTime(date1);
        LocalDateTime localDateTime2 = dateToLocalDateTime(date2);
        return ChronoUnit.DAYS.between(localDateTime2, localDateTime1);
    }

    public static long betweenDays(LocalDateTime date1, LocalDateTime date2) {
        return ChronoUnit.DAYS.between(date2, date1);
    }

    public static long betweenDays(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date2, date1);
    }

    public static long betweenMinutes(Date date1, Date date2) {
        LocalDateTime localDateTime1 = dateToLocalDateTime(date1);
        LocalDateTime localDateTime2 = dateToLocalDateTime(date2);
        return ChronoUnit.MINUTES.between(localDateTime2, localDateTime1);
    }

    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long getMilliByTime(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        } else {
            return field == ChronoUnit.MONTHS ? (period.getYears() * 12L + period.getMonths()) : field.between(startTime, endTime);
        }
    }

    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    public static LocalDateTime timestampToDatetime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
