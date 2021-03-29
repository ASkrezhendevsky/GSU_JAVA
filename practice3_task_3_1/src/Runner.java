import by.gsu.pms.*;

public class Runner {
    public static void main(String[] args) {
        Person[] people = {
                new Worker("name1", "machine1"),
                new Foreman("name2", 1),
                new Director("name3", 1),
        };

        for (Person person: people) {
            System.out.println(person.toString());
        }
    }
}
