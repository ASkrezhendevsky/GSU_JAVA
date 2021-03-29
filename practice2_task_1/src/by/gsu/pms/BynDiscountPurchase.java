package by.gsu.pms;

import java.util.Scanner;

public class BynDiscountPurchase extends Purchase{
    private int discount;

    public BynDiscountPurchase() {
        this("", 0,0,0);
    }

    public BynDiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public BynDiscountPurchase(Scanner scanner){
        this(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getCost() {
        return super.getCost() - discount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
