package by.gsu.pms;
import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(){ }

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
        value += otherByn.value;
        return this;
    }

    public Byn sub(Byn otherByn){
        value -= otherByn.value;
        return this;
    }

    public Byn mul(int multiplier){
        value *= multiplier;
        return this;
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

