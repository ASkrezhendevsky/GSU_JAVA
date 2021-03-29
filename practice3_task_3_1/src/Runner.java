import by.gsu.pms.*;

public class Runner {
    public static void main(String[] args) {
        Person[] people = {
                new Turner("name1", "machine1"),
                new Locksmith("name2", "machine2"),
                new Foreman("name3", 1),
                new Director("name4", 1),
        };

        for (Person person: people) {
            System.out.println(person.toString());
        }
    }
}
