// Main class for Assignment 3
public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Anil", 30000);
        Employee employee2 = new Employee(2, "Sonia", 45000);
        Employee employee3 = new Employee(3, "Kiran", 25000);

        System.out.println("Employee Salary Details");
        System.out.println("-----------------------");

        employee1.displayEmployee();
        System.out.println();

        employee2.displayEmployee();
        System.out.println();

        employee3.displayEmployee();
    }
}
