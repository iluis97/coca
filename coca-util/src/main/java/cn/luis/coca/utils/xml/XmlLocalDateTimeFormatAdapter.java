package cn.luis.coca.utils.xml;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * xml转换 LocalDateTime
 *
 * @author luis
 */
public class XmlLocalDateTimeFormatAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    @Override
    public LocalDateTime unmarshal(String v) {
        return StringUtils.isNotBlank(v) ? LocalDateTime.parse(v, DateTimeFormatter.ofPattern(FORMAT)) : null;
    }

    @Override
    public String marshal(LocalDateTime v) {
        return v.format(DateTimeFormatter.ofPattern(FORMAT));
    }

} 