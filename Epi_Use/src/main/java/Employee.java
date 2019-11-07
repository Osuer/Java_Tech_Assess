import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Employee>{
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    NumberFormat formatDouble = new DecimalFormat("#000,000.00");
    String fName = "";
    String sName = "";
    Date employeeDoB;
    int employeeNumber = 0;
    double employeeSalary = 0.00;
    String employeeRole = "";
    String repTo = "";

    // ==== Basic constructor for the Employee Class ====
    public Employee(String name, String surname, Date DoB, int employeeNum, double salary, String role, String reportsTo){
        this.fName = name;
        this.sName = surname;
        this.employeeDoB = DoB;
        this.employeeNumber = employeeNum;
        this.employeeSalary = salary;
        this.employeeRole = role;
        this.repTo = reportsTo;
    }

    // ==== Copy Constructor ====
    public Employee(Employee employee) throws ParseException {
        this.fName = employee.getfName();
        this.sName = employee.getsName();
        this.employeeDoB = employee.getEmployeeDoB();
        this.employeeNumber = employee.getEmployeeNumber();
        this.employeeSalary = employee.getEmployeeSalary();
        this.employeeRole = employee.getEmployeeRole();
        this.repTo = employee.getRepTo();
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
    }

    public Date getEmployeeDoB() {
        return employeeDoB;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String getRepTo() {
        return repTo;
    }


    @Override
    public String toString() {
        return "" +
                "Name: " + fName +
                "\nSurname: " + sName +
                "\nBirth Date: " + formatter.format(employeeDoB) +
                "\nEmployee Number: " + employeeNumber +
                "\nSalary: " + formatDouble.format(employeeSalary) +
                "\nRole Designation: " + employeeRole+
                "\nReports To: " + repTo;

    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.getEmployeeSalary() , this.getEmployeeSalary());
    }
}
