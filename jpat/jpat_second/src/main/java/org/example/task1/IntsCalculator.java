package org.example.task1;

public class IntsCalculator implements Ints {
    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }

    @Override
    public int sum(int a, int b) {
        return (int) target.newFormula()
                .addOperand(a)
                .addOperand(b)
                .calculate(Calculator.Operation.SUM)
                .result();
    }

    @Override
    public int mult(int a, int b) {
        return (int) target.newFormula()
                .addOperand(a)
                .addOperand(b)
                .calculate(Calculator.Operation.MULT)
                .result();
    }

    @Override
    public int pow(int a, int b) {
        return (int) target.newFormula()
                .addOperand(a)
                .addOperand(b)
                .calculate(Calculator.Operation.POW)
                .result();
    }
}
