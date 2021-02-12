package by.gsu.pms;

public class BusinessTrip {
    private static final int DAILY_RATE = 25000;
    private String account;
    private int transportExpenses;
    private int days;

    public BusinessTrip() {
        this("",0,0);
    }

    public BusinessTrip(String account, int transportExpenses, int days) {
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

    public int getTransportExpenses() {
        return transportExpenses;
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

    public int getTotal() {
        return days * DAILY_RATE + transportExpenses;
    }

    public void show() {
        System.out.println("rate = " + DAILY_RATE + "\n"
                +"account = " + account + "\n"
                +"transport = " + transportExpenses + "\n"
                +"days = " + days + "\n"
                +"total = " + getTotal());
    }

    @Override
    public String toString() {
        final String SEPARATOR = ";";
        return DAILY_RATE + SEPARATOR + account + SEPARATOR + transportExpenses + SEPARATOR + days +
                SEPARATOR + getTotal();
    }
}
