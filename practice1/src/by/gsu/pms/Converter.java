package by.gsu.pms;

public class Converter {
    private final double divider;
    private final int roundingNumbers;

    public Converter(double divider, int roundingNumbers) {
        this.divider = divider;
        this.roundingNumbers = roundingNumbers;
    }

    public double convert(int value) {
        int base = (int) Math.pow(10, roundingNumbers);
        return (double) Math.round(value / divider * base) / base;
    }
}
