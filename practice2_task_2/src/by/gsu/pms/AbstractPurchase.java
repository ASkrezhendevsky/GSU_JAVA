package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    private Commodity commodity;
    private int number;

    public AbstractPurchase(Commodity commodity, int number) {
        this.commodity = commodity;
        this.number = number;
    }

    public AbstractPurchase() {

    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost(){
        return commodity.getPrice().mul(number);
    }

    @Override
    public String toString() {
        return commodity + ";" + number;
    }

    @Override
    public int compareTo(AbstractPurchase abstractPurchase) {
        return abstractPurchase.getCost().compareTo(this.getCost());
    }
}
