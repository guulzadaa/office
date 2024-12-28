import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File fileStudents = new File("students.txt");
        File fileTeachers = new File("teachers.txt");
        Scanner scanner  = new Scanner(fileStudents);
        Scanner scanner1 = new Scanner(fileTeachers);
        Office Office = new Office();

        try {
            while (scanner.hasNextLine()) {
                String name = scanner.next();
                String surname = scanner.next();
                int age = Integer.parseInt(scanner.next());
                String gender = scanner.next();
                boolean genderBool;
                genderBool = gender.equals("Male");
                Student student = new Student(name, surname, age, genderBool);
                while (scanner.hasNextInt()) {
                    student.addGrade(Integer.parseInt(scanner.next()));
                }
                Office.addMember(student);
            }
        }catch(NoSuchElementException e) {
            System.out.println("There is no input.");
        }

        try {
            while (scanner1.hasNextLine()) {
                String name = scanner1.next();
                String surname = scanner1.next();
                int age = Integer.parseInt(scanner1.next());
                String gender = scanner1.next();
                String subject = scanner1.next();
                int yearsOfExperience = Integer.parseInt(scanner1.next());
                int salary = Integer.parseInt(scanner1.next());
                boolean genderBool;
                genderBool = gender.equals("Male");
                Teacher teacher = new Teacher(name, surname, age, genderBool, subject, yearsOfExperience, salary);
                Office.addMember(teacher);
            }
        }catch(NoSuchElementException e) {
            System.out.println("There is no input.");
        }

        for (Person person: Office.getMembers()) {
            if (person instanceof Student student) {
                System.out.println(student.getName() + "'s GPA: " + String.format("%2f", student.calculateGPA()));
            }
            if (person instanceof Teacher teacher) {
                if(teacher.getYearsOfExperience() > 10) {
                System.out.println(teacher.getName() + "'s salary before rise: " + teacher.getSalary() + "." + "After the rise: " + teacher.giveRaise(20));
                }
            }
        }

        Office.sortMembers();
        System.out.println("\nThe list of people who work or study at the office: ");
        Office.print();
    }
}
