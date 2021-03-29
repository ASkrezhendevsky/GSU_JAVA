package by.gsu.pms;

public class Worker extends Person implements Employee{
    private String machine;

    public Worker(String name, String machine){
        super(name);
        this.machine = machine;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + machine;
    }
}
