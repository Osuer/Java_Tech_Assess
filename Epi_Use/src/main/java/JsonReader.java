import org.json.JSONObject;

import java.io.*;

public class JsonReader {
    String json = "";


    public void setJson(String json) {
        this.json = json;
    }

    public JSONObject readJsonObjectFromFile(File file) throws IOException {
        JSONObject toReturn;
        //File file = new File("../data/EmployeeDetails");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String json = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            json = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return toReturn = new JSONObject(json);
    }

}
