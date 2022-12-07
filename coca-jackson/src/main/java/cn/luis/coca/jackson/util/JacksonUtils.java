package cn.luis.coca.jackson.util;

import cn.luis.coca.jackson.config.SimpleModuleConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.util.TimeZone;

/**
 * json格式化工具类 implement by Jackson
 *
 * @author Lius
 * @since 1.0
 * created 2022/4/18 17:29
 */
public final class JacksonUtils {

    private static final ObjectMapper OBJ_MAPPER;

    private static final ObjectMapper EXCLUDE_NULL_OBJ_MAPPER;


    static {
        OBJ_MAPPER = configObjectMapper(false);
        EXCLUDE_NULL_OBJ_MAPPER = configObjectMapper(true);
    }

    public static String toJson(Object obj) {
        try {
            return OBJ_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static String toJsonExcludeNull(Object obj) {
        try {
            return EXCLUDE_NULL_OBJ_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return OBJ_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static <T> T fromJsonExcludeNull(String json, Class<T> clazz) {
        try {
            return EXCLUDE_NULL_OBJ_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static <T> T fromJsonType(String json, TypeReference<T> valueTypeRef) {
        try {
            return OBJ_MAPPER.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static <T> T fromJsonTypeExcludeNull(String json, TypeReference<T> valueTypeRef) {
        try {
            return EXCLUDE_NULL_OBJ_MAPPER.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转换异常", e);
        }
    }

    public static ObjectMapper getObjectMapper() {
        return OBJ_MAPPER;
    }

    public static ObjectMapper getExcludeNullObjMapper() {
        return EXCLUDE_NULL_OBJ_MAPPER;
    }

    /**
     * 通过该方法对mapper对象进行设置，所有序列化的对象都将该规则进行序列化
     * 完全控制序列化过程并且不允许外部配置
     */
    public static ObjectMapper configObjectMapper(boolean excludeNull) {
        // Include.Include.ALWAYS 默认
        // Include.NON_DEFAULT 属性为默认值不序列化
        // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
        // Include.NON_NULL 属性为NULL 不序列化
        JsonInclude.Include include = excludeNull ? JsonInclude.Include.NON_NULL : JsonInclude.Include.USE_DEFAULTS;

        /*
         * java.util.Date yyyy-MM-dd HH:mm:ss
         * 支持JDK8 LocalDateTime、LocalDate、 LocalTime
         * Jdk8Module模块支持如Stream、Optional等类
         * 序列化时是否包含所有字段 excludeNull
         * 在序列化一个空对象时时不抛出异常
         * 数字序列化成字符穿且调用BigDecimal.toPlainString()方法
         * 忽略反序列化时在json字符串中存在, 但在java对象中不存在的属性
         */
        return new ObjectMapper()
                // 设置时区
                .setTimeZone(TimeZone.getDefault())
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .registerModule(SimpleModuleConfig.simpleModule())
                .setSerializationInclusion(include)
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                //.enable(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    }

}