// Main class for Assignment 1
public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student(101, "Asha", 92.5);
        Student student2 = new Student(102, "Ravi", 84.0);
        Student student3 = new Student(103, "Meera", 67.5);

        System.out.println("Student Details and Grades");
        System.out.println("--------------------------");

        student1.displayDetails();
        student1.calculateGrade();
        System.out.println();

        student2.displayDetails();
        student2.calculateGrade();
        System.out.println();

        student3.displayDetails();
        student3.calculateGrade();
    }
}
