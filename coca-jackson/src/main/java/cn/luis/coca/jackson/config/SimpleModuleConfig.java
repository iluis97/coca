package cn.luis.coca.jackson.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jdk8.PackageVersion;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * SimpleModule
 *
 * @author lzw
 * @since 1.0
 * 2022/9/29 15:13
 */
public class SimpleModuleConfig {

    private static final ZoneId ZONE = ZoneId.systemDefault();

    private static final DateTimeFormatter FORMATTER_YYYY_MM_DD_HMMSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_HHMMSS = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static SimpleModule simpleModule() {
        SimpleModule module = new SimpleModule("baseModule", PackageVersion.VERSION);

        module.addDeserializer(String.class, new StdDeserializer<String>(String.class) {
            private static final long serialVersionUID = -3410523445291862081L;

            @Override
            public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                String result = StringDeserializer.instance.deserialize(p, ctxt);
                String ts = result.trim();
                return (ts == null || ts.isEmpty()) ? null : ts;
            }
        });

        module.addSerializer(LocalDateTime.class, new StdSerializer<LocalDateTime>(LocalDateTime.class) {
            private static final long serialVersionUID = 3983102809524366420L;

            @Override
            public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider provider) {
                try {
                    jsonGenerator.writeNumber(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                } catch (IOException e) {
                    throw new RuntimeException("时间转换错误!");
                }
            }
        });
        module.addDeserializer(LocalDateTime.class, new StdDeserializer<LocalDateTime>(LocalDateTime.class) {
            private static final long serialVersionUID = -7765313664546764043L;

            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                try {
                    Instant instant = Instant.ofEpochMilli(Long.parseLong(jsonParser.getText()));
                    return LocalDateTime.ofInstant(instant, ZONE);
                } catch (Exception ex) {
                    try {
                        return LocalDateTime.parse(jsonParser.getText(), FORMATTER_YYYY_MM_DD_HMMSS);
                    } catch (Exception e) {
                        throw new RuntimeException("传入参数:" + jsonParser.getText() + "既不是合法日期秒数,也不是! yyyy-MM-dd HH:mm:ss ");
                    }
                }
            }
        });


        module.addDeserializer(LocalTime.class, new JsonDeserializer<LocalTime>() {
            @Override
            public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException {
                try {
                    return LocalTime.parse(jsonParser.getValueAsString(), FORMATTER_HHMMSS);
                } catch (Exception e) {
                    throw new RuntimeException("传入参数:" + jsonParser.getText() + "不是合法 HH:mm:ss ");
                }
            }
        });
        module.addSerializer(LocalTime.class, new JsonSerializer<LocalTime>() {
            @Override
            public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                try {
                    jsonGenerator.writeString(FORMATTER_HHMMSS.format(localTime));
                } catch (Exception ex) {
                    throw new RuntimeException("时间转换错误!");
                }
            }
        });


        module.addSerializer(LocalDate.class, new StdSerializer<LocalDate>(LocalDate.class) {
            private static final long serialVersionUID = -7929121892882698436L;

            @Override
            public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider provider) {
                try {
                    jsonGenerator.writeNumber(localDate.atTime(0, 0, 0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                } catch (IOException e) {
                    throw new RuntimeException("时间转换错误!");
                }
            }
        });

        module.addDeserializer(LocalDate.class, new StdDeserializer<LocalDate>(LocalDate.class) {
            private static final long serialVersionUID = 3697721414363137776L;

            @Override
            public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                try {
                    Instant instant = Instant.ofEpochMilli(Long.parseLong(jsonParser.getText()));
                    return LocalDateTime.ofInstant(instant, ZONE).toLocalDate();
                } catch (Exception ex) {
                    throw new RuntimeException("传入参数:" + jsonParser.getText() + "不是合法日期秒数!");
                }
            }
        });

        module.addSerializer(Date.class, new StdSerializer<Date>(Date.class) {
            private static final long serialVersionUID = -3155313320490990299L;

            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider) {
                try {
                    jsonGenerator.writeNumber(date.getTime());
                } catch (IOException e) {
                    throw new RuntimeException("时间转换错误!");
                }
            }
        });
        module.addDeserializer(Date.class, new StdDeserializer<Date>(Date.class) {
            private static final long serialVersionUID = -4595415096209435223L;

            @Override
            public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                try {
                    return new Date(Long.parseLong(jsonParser.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException("传入参数:" + jsonParser.getText() + "不是合法日期秒数!");
                }
            }
        });
        return module;
    }

}
