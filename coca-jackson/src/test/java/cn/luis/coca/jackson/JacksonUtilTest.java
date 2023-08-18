package cn.luis.coca.jackson;

import cn.luis.coca.jackson.domain.Person;
import cn.luis.coca.jackson.util.JacksonUtils;
import org.junit.jupiter.api.Test;

public class JacksonUtilTest {

    @Test
    public void test() {
        Person person = new Person();
        person.setAge(12);

        String json = JacksonUtils.toJson(person);

        System.out.println(json);

        Person person1 = JacksonUtils.fromJson(json, Person.class);

        System.out.println(json);

    }


}
