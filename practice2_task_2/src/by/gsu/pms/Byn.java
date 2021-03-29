package by.gsu.pms;
import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(){ this(0); }

    public Byn(int value){
        this.value = value;
    }

    public Byn(Byn byn){
        this(byn.value);
    }

    public Byn(int rubs, int coins){
        this(rubs * 100 + coins);
    }

    public Byn(Scanner sc){
        this(sc.nextInt());
    }

    public Byn add(Byn otherByn) {
        return new Byn(value + otherByn.value);
    }

    public Byn sub(Byn otherByn){
        return new Byn(value - otherByn.value);
    }

    public Byn mul(int multiplier){
        return new Byn(value * multiplier);
    }

    public Byn mul(double multiplier){
        return new Byn((int)Math.round(value * multiplier));
    }

    @Override
    public String toString() {
        return value/100+"."+ value % 100 / 10 + value % 10;
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }
}

