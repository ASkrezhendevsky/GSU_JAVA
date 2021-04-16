package by.gsu.pms.beans;

import by.gsu.pms.utils.RoundMethod;

import java.time.Year;

public class IncomeTax extends AbstractTax{
    private Byn income;
    private double taxRate;

    public IncomeTax(Year year, Byn income, double taxRate){
        super(year);
        this.income = income;
        this.taxRate = taxRate;
    }

    public Byn getIncome() {
        return income;
    }

    public void setIncome(Byn income) {
        this.income = income;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    Byn getValue() {
        return income.multiply(taxRate, RoundMethod.ROUND);
    }
}
