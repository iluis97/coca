package cn.luis.coca.utils.xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * xml转换工具
 *
 * @author luis
 */
public final class XmlModelUtils {

    /**
     * 自定义生成xml的默认报文头
     */
    private static final String DEFAULT_XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    private static final String UTF_8 = "UTF-8";

    private XmlModelUtils() {
    }

    /**
     * 对象转XML
     */
    public static <T extends XmlModel> String bean2Xml(T entity, Class<T> clz) {
        JAXBContext jc;

        try (Writer writer = new StringWriter()) {
            jc = JAXBContext.newInstance(clz);
            Marshaller ms = jc.createMarshaller();

            ms.setListener(MarshallerListener.instance);
            //编码格式 (使用 StandardCharsets.UTF_8 会报错)
            ms.setProperty(Marshaller.JAXB_ENCODING, UTF_8);
            // 是否格式化生成的xml串
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // 是否省略xm头声明信息
            ms.setProperty(Marshaller.JAXB_FRAGMENT, true);

            // 自定义生成xml的默认报文头
            writer.append(DEFAULT_XML_HEAD);
            ms.marshal(entity, writer);
            return writer.toString();

        } catch (IOException | JAXBException e) {
            throw new RuntimeException("对象转XML异常", e);
        }
    }

    /**
     * XML转对象
     */
    @SuppressWarnings("unchecked")
    public static <T extends XmlModel> T xml2Bean(String xml, final Class<T> clz) {
        try {
            // 将外部实体、参数实体和内联DTD 都设置为false，从而避免XXE漏洞
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml.replace("\r\n", ""))));

            JAXBContext context = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(xmlSource);
        } catch (ParserConfigurationException | SAXException | JAXBException e) {
            throw new RuntimeException("XML转对象异常", e);
        }
    }

}