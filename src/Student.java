import java.util.ArrayList;

public class Student extends Person {
    private static int id_gen = 1;
    private int studentID;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        studentID = id_gen++;
        grades = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public double calculateGPA() {
        int total = 0;
        for(int grade : grades) {
            total += grade;
        }
        return grades.size() > 0 ? (double) total / grades.size() : 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "I am a student with ID " + studentID + ".";
    }
}
