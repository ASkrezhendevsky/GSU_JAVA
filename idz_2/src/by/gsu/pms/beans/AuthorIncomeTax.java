package by.gsu.pms.beans;

import java.time.Year;

public class AuthorIncomeTax extends IncomeTax{
    AuthorIncomeTax(Byn income, double taxRate, Year year) {
        super(income, taxRate, year);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
