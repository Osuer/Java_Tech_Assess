import java.util.Comparator;
import java.lang.Comparable;
public class EmployeeSalaryComparator implements Comparator<Employee>{
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp2.getEmployeeSalary(), emp1.getEmployeeSalary());
    }
}
