package cn.luis.coca.utils.xml;

import javax.xml.bind.Marshaller;
import java.lang.reflect.Field;

/**
 * 监听
 *
 * @author lzw
 */
public class MarshallerListener extends Marshaller.Listener {

    public static final String BLANK_CHAR = "";

    /**
     * 轻量同步 volatile
     */
    public volatile static MarshallerListener instance = new MarshallerListener();


    @Override
    public void beforeMarshal(Object source) {
        super.beforeMarshal(source);
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            // 获取字段上注解
            try {
                if (f.getType() == String.class && f.get(source) == null) {
                    f.set(source, BLANK_CHAR);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}