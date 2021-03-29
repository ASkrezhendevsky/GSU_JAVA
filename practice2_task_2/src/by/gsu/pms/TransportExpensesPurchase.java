package by.gsu.pms;

public class TransportExpensesPurchase extends AbstractPurchase{
    private Byn transportExpenses;

    public TransportExpensesPurchase(Commodity commodity, int number, Byn transportExpenses) {
        super(commodity, number);
        this.transportExpenses = transportExpenses;
    }

    public Byn getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Byn transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    @Override
    public Byn getCost() {
        return super.getCost().add(transportExpenses);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
}
