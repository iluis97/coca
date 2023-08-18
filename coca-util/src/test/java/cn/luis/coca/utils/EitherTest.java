package cn.luis.coca.utils;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * either mock scala#either
 * 可实现异常的传递
 *
 * @author Luis
 * @version 1.0
 * @since 1.0
 */
public class EitherTest {

    /**
     * 输出全部错误
     */
    public static Student readLine(int line) throws RuntimeException {
        if (new Random().nextBoolean()) {
            return new Student("z3", 22);
        } else {
            throw new RuntimeException("第" + line + "行数据有误");
        }
    }

    public static Either<Student, RuntimeException> readLineEitherException(int line) {
        if (new Random().nextBoolean()) {
            //if (true) {
            return Either.ofExpected(new Student("z3", 22));
        } else {
            return Either.ofActual(new RuntimeException("第" + line + "行数据有误"));
        }
    }

    public static Either<Student, String> readLineEitherMsg(int line) {
        if (new Random().nextBoolean()) {
            return Either.ofExpected(new Student("z3", 22));
        } else {
            return Either.ofActual(new RuntimeException("第" + line + "行数据有误").getMessage());
        }
    }

    /**
     * 只能输出第一行错误，程序就终止了
     */
    @Test
    public void test1() {
        List<Student> students = Stream.iterate(1, i -> i + 1)
                .limit(100)
                .map(i -> {
                    try {
                        return readLine(i);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        students.forEach(System.out::println);
    }

    /**
     * 只能输出第一行错误，程序就终止了
     */
    @Test
    public void testEitherException() {
        List<Either<Student, RuntimeException>> eitherList = Stream.iterate(1, i -> i + 1)
                .limit(100)
                .map(EitherTest::readLineEitherException)
                .collect(Collectors.toList());

        Either<List<Student>, List<RuntimeException>> either = Either.sequence(eitherList);
        if (either.isExpected()) {
            List<Student> students = either.getExpected();
            students.forEach(System.out::println);
        } else {
            List<RuntimeException> exceptions = either.getActual();
            for (RuntimeException exception : exceptions) {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * 输出全部错误
     */
    @Test
    public void testEither() {
        List<Either<Student, String>> eitherList = Stream.iterate(1, i -> i + 1)
                .limit(100)
                .map(EitherTest::readLineEitherMsg)
                .collect(Collectors.toList());

        Either<List<Student>, String> either = Either.sequence(eitherList, (s1, s2) -> s1 + "\n" + s2);
        if (either.isExpected()) {
            List<Student> students = either.getExpected();
            students.forEach(System.out::println);
        } else {
            System.out.println(either.getActual());
        }

    }

    @Test
    public void testMap() {
        Student z3 = new Student("z3", 22);
        Either<Student, String> either = new Either<>();
        Either<Student, String> z31 = either.map((s) -> z3);
        System.out.println(z31);
    }

    // student class

    @ToString
    @AllArgsConstructor
    static class Student {
        private String name;
        private Integer age;
    }

}
