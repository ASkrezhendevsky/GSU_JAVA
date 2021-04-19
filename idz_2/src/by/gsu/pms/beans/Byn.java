package by.gsu.pms.beans;

import by.gsu.pms.utils.RoundMethod;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn() {
        value = 0;
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn subtract(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn multiply(int multiplier) {
        return new Byn(value * multiplier);
    }

    public Byn multiply(double multiplier, RoundMethod roundMethod) {
        return new Byn((int) roundMethod.round(value * multiplier));
    }

    public Byn divide(int divider) {
        return multiply(1 / divider);
    }

    public Byn divide(double divider, RoundMethod roundMethod) {
        return multiply(1 / divider, roundMethod);
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
