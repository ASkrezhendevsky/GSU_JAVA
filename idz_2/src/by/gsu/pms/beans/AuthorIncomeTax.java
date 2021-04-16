package by.gsu.pms.beans;

import java.time.Year;

public class AuthorIncomeTax extends IncomeTax{
    public AuthorIncomeTax(Year year, Byn income, double taxRate) {
        super(year, income, taxRate);
    }
}
