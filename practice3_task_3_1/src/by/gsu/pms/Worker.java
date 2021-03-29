package by.gsu.pms;

public abstract class Worker implements Employee, Person{
    private String machine;
    private String name;

    public Worker(String name, String machine){
        this.name = name;
        this.machine = machine;
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
        return name + ";" + machine;
    }
}
