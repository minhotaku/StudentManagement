import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        do{
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndModifyStudentsByFullName();
                    break;
                case 4:
                    running = false;
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Not a valid option. A number between 1 and 4 please..");
            }
        }while (running);
    }

    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numStudents; i++) {
            System.out.printf("Enter first name of student %d : ", i);
            String firstName = scanner.nextLine();
            System.out.printf("Enter last name of student %d : ", i);
            String lastName = scanner.nextLine();
            Student newStudent = new Student(firstName, lastName);
            studentList.add(newStudent);
        }
    }

    private static void findStudentsByLastName() {
        System.out.print("Enter last name to search for: ");
        String lastName = scanner.nextLine();

        boolean found = false;

        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with the last name '" + lastName + "'.");
        }
    }

    private static void findAndModifyStudentsByFullName() {
        boolean found = false;

        System.out.print("Enter full name to search for: ");
        String fullName = scanner.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.toString().equalsIgnoreCase(fullName)) {

                System.out.println("Student found: " + student);
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine();

                student.setFirstName(newFirstName);
                student.setLastName(newLastName);

                System.out.println("Student details updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No students found with the name : " + fullName );
        }
    }
}
