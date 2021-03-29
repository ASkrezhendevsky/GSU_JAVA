package by.gsu.pms;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private int price;
    private int number;

    public Purchase(){
        this("", 0, 0);
    }

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner scanner){
        this(scanner.next(), scanner.nextInt(), scanner.nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public final String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString(){
        return name + ";" + price + ";" + number;
    }

    public int getCost(){
        return number*price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price && Objects.equals(name, purchase.name);
    }
}
