import java.util.ArrayList;
import java.util.Comparator;

public class Office {
    private final ArrayList<Person> members;

    public Office() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public void sortMembers() {
        members.sort(Comparator.comparing(Person::getSurname));
    }

    public void print() {
        for (Person person : members) {
            System.out.println(person);
        }
    }
}
