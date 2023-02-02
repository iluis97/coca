package cn.luis.coca.jackson.domain;

/**
 * @author Luis
 * @version 1.0
 * @since 1.0
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
