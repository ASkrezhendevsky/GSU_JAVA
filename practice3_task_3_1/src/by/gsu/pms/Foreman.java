package by.gsu.pms;

public class Foreman extends Employee{
    private int computerNum;

    public Foreman(String name, int computerNum){
        super(name);
        this.computerNum = computerNum;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + computerNum;
    }
}
