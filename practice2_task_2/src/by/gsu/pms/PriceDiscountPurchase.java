package by.gsu.pms;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    public PriceDiscountPurchase(Commodity commodity, int number, Byn discount) {
        super(commodity, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    public PriceDiscountPurchase(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + discount;
    }
}
