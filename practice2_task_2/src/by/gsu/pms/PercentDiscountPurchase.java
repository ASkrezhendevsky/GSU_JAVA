package by.gsu.pms;

public class PercentDiscountPurchase extends AbstractPurchase{
    private double discount;

    public PercentDiscountPurchase(Commodity commodity, int number, int discount) {
        super(commodity, number);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().mul((100 - discount)/100);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
