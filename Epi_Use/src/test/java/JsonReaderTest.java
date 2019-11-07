import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class JsonReaderTest {
    JsonReader reader;
    @Before
    public void setUp() throws Exception {
        reader = new JsonReader();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readJsonObjectFromFile() throws IOException {
        String jsonString = "{\"Employees\":[{\"Salary\":\"700000\",\"RoleDesignation\":\"Manager\",\"EmployeeNumber\":\"1\",\"ReportsTo\":\"\",\"Birth Date\":\"12-10-1985\",\"Surname\":\"Smith\",\"Name\":\"John\"}]}";
        JSONObject expectedObject;
        JSONObject actualObject;
        File file = new File("src/main/data/ReadFromFileTest");
        actualObject = reader.readJsonObjectFromFile(file);
        expectedObject = new JSONObject(jsonString);
        assertEquals("Employee Key Missing!", expectedObject.toString(), actualObject.toString());
    }
}