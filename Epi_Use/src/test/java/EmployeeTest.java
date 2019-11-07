import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee emp1;
    Employee emp2;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    @Before
    public void setUp() throws Exception {
        Date dob = formatter.parse("01-01-2000");
        emp1 = new Employee("Chane", "Bornman", dob, 1,150000,"Manager","Test");
        emp2 = new Employee("Chane", "Bornman", dob, 1,175000,"Manager","Test");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        String expected = "Name: Chane\nSurname: Bornman\nBirth Date: 01-01-2000\nEmployee Number: 1\nSalary: 150,000.00\nRole Designation: Manager\nReports To: Test";

        assertEquals("Test To string not in the right format!", expected, emp1.toString());
    }

    @Test public void testCompareTo(){

        assertEquals("Function sorts the wrong way!", 1,  emp1.compareTo(emp2));
    }
}