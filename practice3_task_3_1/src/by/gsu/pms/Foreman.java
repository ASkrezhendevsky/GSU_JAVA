package by.gsu.pms;

public class Foreman implements Employee, Person{
    private int computerNum;
    private String name;

    public Foreman(String name, int computerNum){
        this.name = name;
        this.computerNum = computerNum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ";" + computerNum;
    }
}
