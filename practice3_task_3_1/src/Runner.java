import by.gsu.pms.Foreman;
import by.gsu.pms.Director;
import by.gsu.pms.Employee;
import by.gsu.pms.Worker;

public class Runner {
    public static void main(String[] args) {
        Employee[] employees = {
                new Worker("name1", "machine1"),
                new Foreman("name1", 1),
                new Director("name1", 1),
        };
    }
}
