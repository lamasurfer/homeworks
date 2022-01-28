package task1_1;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    public Calculator() {
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = this::doSafeDivision;

    UnaryOperator<Integer> pow = x -> x * x;
//    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
//    что-то я не понял в чем с ним проблема)
//    он и так работал, я бы только без умножения сделал или вообще Math.abs
//    UnaryOperator<Integer> abs = x -> (x < 0) ? -x : x;
    UnaryOperator<Integer> abs = Math::abs;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Number> println = System.out::println;

    private Integer doSafeDivision(Integer x, Integer y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.print("Деление на ");
            return y;
        }
    }
}
