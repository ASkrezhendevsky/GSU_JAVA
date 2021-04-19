package by.gsu.pms.beans;

import java.time.Year;

public class PresentTax extends AbstractTax{
    private Byn price;
    private boolean fromRelatives = false;

    private static final Byn MAX_PRICE = new Byn(6000000);

    public PresentTax(Year year, Byn price, boolean fromRelatives) {
        super(year);
        this.price = price;
        this.fromRelatives = fromRelatives;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public boolean isFromRelatives() {
        return fromRelatives;
    }

    public void setFromRelatives(boolean fromRelatives) {
        this.fromRelatives = fromRelatives;
    }

    @Override
    Byn getValue() {
        if(price.compareTo(MAX_PRICE) > 0 && fromRelatives)
            return new Byn(0);
        return price;
    }
}
