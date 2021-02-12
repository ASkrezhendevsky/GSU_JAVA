package by.gsu.pms;

public class Converter {
    private final double delimiter;
    private final int roundingNumbers;

    public Converter(double delimiter, int roundingNumbers) {
        this.delimiter = delimiter;
        this.roundingNumbers = roundingNumbers;
    }

    public int convert(int value){
        int base = (int)Math.pow(10, roundingNumbers);
        return (int)Math.round(value/delimiter/base)*base;
    }
}
