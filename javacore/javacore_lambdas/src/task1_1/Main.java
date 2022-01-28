package task1_1;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);
        calc.println.accept(c);

        int d = calc.multiply.apply(5, -1);
        calc.println.accept(d);

        System.out.println(calc.isPositive.test(d));


        int e = calc.abs.apply(-25);
        calc.println.accept(e);
    }
}
