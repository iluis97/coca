package cn.luis.coca.utils.xml;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * xml转换 Date
 *
 * @author luis
 */
public class XmlDateFormatYmdAdapter extends XmlAdapter<String, Date> {

    private static final String FORMAT = "yyyy-MM-dd";

    @Override
    public Date unmarshal(String v) throws Exception {
        return StringUtils.isNotBlank(v) ? new SimpleDateFormat(FORMAT).parse(v) : null;
    }

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(FORMAT).format(v);
    }
}