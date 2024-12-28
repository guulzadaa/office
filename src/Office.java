import java.util.ArrayList;

public class Office {
    private ArrayList<Person> members;

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
        members.sort((p1, p2) -> p1.getSurname().compareTo(p2.getSurname()));
    }

    public void print() {
        for (Person person : members) {
            System.out.println(person);
        }
    }
}
