package by.gsu.pms;

public class BusinessTrip {
    private static final int DAILY_RATE = 25000;
    private String account;
    private int transportExpenses;
    private int days;
    private Converter converter;

    public BusinessTrip() {
        this("",0,0);
    }

    public BusinessTrip(String account, int transportExpenses, int days) {
        this.converter = new Converter(100,2);
        this.account = account;
        this.transportExpenses = transportExpenses;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getTransportExpenses() {
        return converter.convert(transportExpenses);
    }

    public void setTransportExpenses(int transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotal() {
        return converter.convert(days * DAILY_RATE + transportExpenses);
    }

    public void show() {
        System.out.println("rate = " + converter.convert(DAILY_RATE) + "\n"
                +"account = " + account + "\n"
                +"transport = " + getTransportExpenses() + "\n"
                +"days = " + days + "\n"
                +"total = " + getTotal());
    }

    @Override
    public String toString() {
        final String SEPARATOR = ";";
        return converter.convert(DAILY_RATE) + SEPARATOR + account + SEPARATOR + getTransportExpenses() + SEPARATOR + days +
                SEPARATOR + getTotal();
    }
}
