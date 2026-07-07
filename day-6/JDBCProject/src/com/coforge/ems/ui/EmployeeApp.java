package com.coforge.ems.ui;

import com.coforge.ems.controller.EmployeeController;
import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;

import java.util.List;
import java.util.Scanner;

// This class provides the menu-driven console interface for the application.
public class EmployeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeController controller = new EmployeeController();

        while (true) {
            System.out.println();
            System.out.println(ApplicationProperties.MENU_TEXT);

            int choice = readInt(scanner, ApplicationProperties.MENU_PROMPT);

            switch (choice) {
                case ApplicationProperties.MENU_OPTION_ADD:
                    Employee addEmp = new Employee();
                    addEmp.setEmpId(readInt(scanner, ApplicationProperties.ENTER_EMPLOYEE_ID));
                    System.out.print(ApplicationProperties.ENTER_EMPLOYEE_NAME);
                    addEmp.setEmpName(scanner.nextLine());
                    addEmp.setEmpSalary(readDouble(scanner, ApplicationProperties.ENTER_EMPLOYEE_SALARY));
                    System.out.print(ApplicationProperties.ENTER_EMPLOYEE_DEPARTMENT);
                    addEmp.setEmpDepartment(scanner.nextLine());
                    System.out.print(ApplicationProperties.ENTER_EMPLOYEE_EMAIL);
                    addEmp.setEmpEmail(scanner.nextLine());
                    System.out.println(controller.addEmployee(addEmp));
                    break;

                case ApplicationProperties.MENU_OPTION_VIEW:
                    List<Employee> employees = controller.viewEmployees();
                    if (employees == null || employees.isEmpty()) {
                        System.out.println(ApplicationProperties.NO_EMPLOYEES_FOUND);
                    } else {
                        for (Employee employee : employees) {
                            System.out.println(employee);
                        }
                    }
                    break;

                case ApplicationProperties.MENU_OPTION_SEARCH:
                    int searchId = readInt(scanner, ApplicationProperties.ENTER_EMPLOYEE_ID_TO_SEARCH);
                    Employee foundEmployee = controller.searchEmployee(searchId);
                    if (foundEmployee == null) {
                        System.out.println(ApplicationProperties.EMPLOYEE_NOT_FOUND);
                    } else {
                        System.out.println(foundEmployee);
                    }
                    break;

                case ApplicationProperties.MENU_OPTION_UPDATE:
                    Employee updateEmp = new Employee();
                    updateEmp.setEmpId(readInt(scanner, ApplicationProperties.ENTER_EMPLOYEE_ID_TO_UPDATE));
                    System.out.print(ApplicationProperties.ENTER_NEW_EMPLOYEE_NAME);
                    updateEmp.setEmpName(scanner.nextLine());
                    updateEmp.setEmpSalary(readDouble(scanner, ApplicationProperties.ENTER_NEW_EMPLOYEE_SALARY));
                    System.out.print(ApplicationProperties.ENTER_NEW_EMPLOYEE_DEPARTMENT);
                    updateEmp.setEmpDepartment(scanner.nextLine());
                    System.out.print(ApplicationProperties.ENTER_NEW_EMPLOYEE_EMAIL);
                    updateEmp.setEmpEmail(scanner.nextLine());
                    System.out.println(controller.updateEmployee(updateEmp));
                    break;

                case ApplicationProperties.MENU_OPTION_DELETE:
                    int deleteId = readInt(scanner, ApplicationProperties.ENTER_EMPLOYEE_ID_TO_DELETE);
                    System.out.println(controller.deleteEmployee(deleteId));
                    break;

                case ApplicationProperties.MENU_OPTION_EXIT:
                    System.out.println(ApplicationProperties.EXIT_MESSAGE);
                    scanner.close();
                    return;

                default:
                    System.out.println(ApplicationProperties.INVALID_CHOICE_TRY_AGAIN);
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                System.out.println();
                return ApplicationProperties.MENU_OPTION_EXIT;
            }

            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(ApplicationProperties.PLEASE_ENTER_VALID_NUMBER);
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                System.out.println();
                return 0.0;
            }

            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(ApplicationProperties.PLEASE_ENTER_VALID_NUMBER);
            }
        }
    }
}
