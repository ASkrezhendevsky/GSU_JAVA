package by.gsu.pms;

public class PercentDiscountPurchase extends AbstractPurchase{
    int double discount;

    public PercentDiscountPurchase(Commodity commodity, int number, double discount) {
        super(commodity, number);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().mul(discount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
