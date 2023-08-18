package cn.luis.coca.utils;

import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * either mock scala#either
 * 可实现异常的传递
 *
 * @author Luis
 * @version 1.0
 * @since 1.0
 */
public class Either<Expected, Actual> {

    private Expected expected;
    private Actual actual;

    public static <Expected, Actual> Either<Expected, Actual> ofExpected(Expected expected) {
        Either<Expected, Actual> either = new Either<>();
        either.setExpected(expected);
        return either;
    }

    public static <Expected, Actual> Either<Expected, Actual> ofActual(Actual actual) {
        Either<Expected, Actual> either = new Either<>();
        either.setActual(actual);
        return either;
    }

    public static <Expected, Actual> Either<List<Expected>, List<Actual>> sequence(List<Either<Expected, Actual>> eitherList) {
        if (eitherList.stream().allMatch(Either::isExpected)) {
            return ofExpected(eitherList.stream()
                    .map(Either::getExpected)
                    .collect(Collectors.toList()));
        } else {
            return ofActual(eitherList.stream()
                    .filter(Either::isActual)
                    .map(Either::getActual)
                    .collect(Collectors.toList()));
        }
    }

    /**
     * 对Actual做处理
     * Java 8 函数式接口 <a href="https://www.runoob.com/java/java8-functional-interfaces.html"></a>
     */
    public static <Expected, Actual> Either<List<Expected>, Actual> sequence(List<Either<Expected, Actual>> eitherList, BinaryOperator<Actual> actualBinaryOperator) {
        if (eitherList.stream().allMatch(Either::isExpected)) {
            return ofExpected(eitherList.stream()
                    .map(Either::getExpected)
                    .collect(Collectors.toList()));
        } else {
            return ofActual(eitherList.stream()
                    .filter(Either::isActual)
                    .map(Either::getActual)
                    .reduce(actualBinaryOperator)
                    .orElseThrow(() -> new RuntimeException("actual no data"))
            );
        }
    }

    public boolean isExpected() {
        return Objects.nonNull(expected);
    }

    public boolean isActual() {
        return Objects.nonNull(actual);
    }

    public <T> Either<T, Actual> map(Function<Expected, T> function) {
        return isActual() ? ofActual(actual) : ofExpected(function.apply(expected));
    }


    // get、set

    public Expected getExpected() {
        return expected;
    }

    public void setExpected(Expected expected) {
        this.expected = expected;
    }

    public Actual getActual() {
        return actual;
    }

    public void setActual(Actual actual) {
        this.actual = actual;
    }
}
