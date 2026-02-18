import java.util.Scanner;
interface Payroll {
    void calculateSalary();
    void displayDetails();
}

class Employee implements Payroll {
    private int id;
    private String name;
    private double basicSalary;
    private double finalSalary;
    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getId() {
        return id;
    }
    public void calculateSalary() {
        double hra = basicSalary * 0.20;   // 20% HRA
        double da = basicSalary * 0.10;    // 10% DA
        finalSalary = basicSalary + hra + da;
    }
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Final Salary: " + finalSalary);
        System.out.println("----------------------------");
    }
}
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] emp = new Employee[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count < 5) {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Basic Salary: ");
                        double salary = sc.nextDouble();

                        emp[count] = new Employee(id, name, salary);
                        emp[count].calculateSalary();
                        count++;

                        System.out.println("Employee Added Successfully!");
                    } else {
                        System.out.println("Employee Limit Reached!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No Employees Found!");
                    } else {
                        for (int i = 0; i < count; i++) {
                            emp[i].displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Payroll System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
