package cn.luis.coca.utils.xml;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * xml转换 LocalDate
 *
 * @author luis
 */
public class XmlLocalDateFormatAdapter extends XmlAdapter<String, LocalDate> {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    @Override
    public LocalDate unmarshal(String v) {
        return StringUtils.isNotBlank(v) ? LocalDate.parse(v, DateTimeFormatter.ofPattern(FORMAT)) : null;
    }

    @Override
    public String marshal(LocalDate v) {
        return v.format(DateTimeFormatter.ofPattern(FORMAT));
    }

} 