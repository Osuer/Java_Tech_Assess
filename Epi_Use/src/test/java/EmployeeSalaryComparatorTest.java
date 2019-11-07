import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeSalaryComparatorTest {
    EmployeeSalaryComparator empComp;
    @Before
    public void setUp() throws Exception {
        EmployeeSalaryComparator empComp = new EmployeeSalaryComparator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compare_test_salary_comparator() {
        Employee emp1 = new Employee("emp1" , "surname1", new Date(), 1, 600000, "Manager", "");
        Employee emp2 = new Employee("emp2" , "surname2", new Date(), 2, 550000, "Manager", "");

        assertEquals("compare test salary comparator failed",-1, empComp.compare(emp1, emp2));
    }
}