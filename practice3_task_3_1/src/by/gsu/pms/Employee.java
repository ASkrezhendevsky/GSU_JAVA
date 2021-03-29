package by.gsu.pms;

public class Employee {
    private String name;

    public Employee(){
        this("");
    }

    public Employee(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
