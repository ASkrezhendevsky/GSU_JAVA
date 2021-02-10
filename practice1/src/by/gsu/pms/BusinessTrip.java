package by.gsu.pms;

public class BusinessTrip {
    private static final int DAILY_RATE = 25000;
    private String account;
    private int transportExpanses;
    private int days;

    public BusinessTrip() {
        this("",0,0);
    }

    public BusinessTrip(String account, int transportExpanses, int days) {
        this.account = account;
        this.transportExpanses = transportExpanses;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportExpanses() {
        return transportExpanses;
    }

    public void setTransportExpanses(int transportExpanses) {
        this.transportExpanses = transportExpanses;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal() {
        return days * DAILY_RATE + transportExpanses;
    }

    public void show() {
        System.out.println("rate = " + DAILY_RATE + "\n"
                +"account = " + account + "\n"
                +"transport = " + transportExpanses + "\n"
                +"days = " + days + "\n"
                +"total = " + getTotal());
    }

    @Override
    public String toString() {
        final String SEPARATOR = ";";
        return DAILY_RATE + SEPARATOR + account + SEPARATOR + transportExpanses + SEPARATOR + days +
                SEPARATOR + getTotal();
    }
}
