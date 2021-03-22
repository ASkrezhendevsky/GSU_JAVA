package by.gsu.pms;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn dicount;

    public PriceDiscountPurchase(Commodity commodity, int number, Byn dicount) {
        super(commodity, number);
        this.dicount = dicount;
    }

    public Byn getDicount() {
        return dicount;
    }

    public void setDicount(Byn dicount) {
        this.dicount = dicount;
    }

    public PriceDiscountPurchase(Byn dicount) {
        this.dicount = dicount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(dicount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + dicount;
    }
}
