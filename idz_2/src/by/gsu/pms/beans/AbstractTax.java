package by.gsu.pms.beans;

import java.time.Year;

public abstract class AbstractTax implements Comparable<AbstractTax> {
    private Year year;

    protected AbstractTax() {

    }

    protected AbstractTax(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    abstract Byn getValue();

    @Override
    public int compareTo(AbstractTax tax) {
        return getValue().compareTo(tax.getValue());
    }

    @Override
    public String toString() {
        return fieldsToString() + getValue();
    }

    protected String fieldsToString(){
        return "";
    }
}
