import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ProgramFunctionsTest {
    ProgramFunctions function;
    Employee emp;
    ArrayList empList = new ArrayList<Employee>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    @Before
    public void setUp() throws Exception {
        function = new ProgramFunctions();
        Date dob = formatter.parse("01-01-2000");
        emp = new Employee("Chane", "Bornman", dob, 1,150000,"Manager","Test");
        empList.add(emp);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printSearchedForEmployee() {
        String expected = "This employee name could not be found!";
        assertEquals("Employee does not exist but nothing happens!", expected, function.printSearchedForEmployee("John", empList));
        expected = emp.toString();
        assertEquals("Employee details not printed right!", expected, function.printSearchedForEmployee("Chane", empList));
    }

    @Test
    public void getEmployeesOlderThanSpecifiedDateToString() {
    }
}