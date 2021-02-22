package by.gsu.pms;

public class Butter implements Comparable<Butter> {
    private String name;
    private int price;
    private boolean hasSupplements;

    public Butter() {
        this("", 0, false);
    }

    public Butter(String name, int price, boolean hasSupplements) {
        this.name = name;
        this.price = price;
        this.hasSupplements = hasSupplements;
    }

    public Butter(String name, int price){
        this(name, price, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isHasSupplements() {
        return hasSupplements;
    }

    public void setHasSupplements(boolean hasSupplements) {
        this.hasSupplements = hasSupplements;
    }

    @Override
    public int compareTo(Butter butter) {
        return price - butter.getPrice();
    }

    @Override
    public String toString() {
        return "Butter{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", hasSupplements=" + hasSupplements +
                '}';
    }
}
