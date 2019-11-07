import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    //========================================
    //Maybe die 3 in n static class sit? Kan dan maybe ook die Json reader daar use en nie in main nie
    static HashMap<String, EmployeeNode> nodeList;
    static ArrayList<Employee> EmployeeList;
    static HashMap<String, List<String>> reportToMap;
    //===================================


    public static void main(String[] args) throws ParseException {
        nodeList = new HashMap<String , EmployeeNode>();
        reportToMap = new HashMap<String, List<String>>();
        ProgramFunctions function = new ProgramFunctions();
        File file = new File("src/main/data/EmployeeDetails");
        JsonReader reader = new JsonReader();
        JSONArray jsonArray = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            JSONObject jsonObj = reader.readJsonObjectFromFile(file);
            jsonArray = jsonObj.getJSONArray("Employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmployeeNode tempNode;
        EmployeeList = new ArrayList(jsonArray.length());
        for(int i=0; i<jsonArray.length(); i++) {
            JSONObject temp = jsonArray.getJSONObject(i);

            String DoB = temp.getString("Birth Date");

            Date dob = new Date();
            try {
                dob = formatter.parse(DoB);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Employee tempEmp = new Employee(temp.getString("Name"), temp.getString("Surname"), dob , temp.getInt("EmployeeNumber"), temp.getDouble("Salary"), temp.getString("RoleDesignation"), temp.getString("ReportsTo"));
            EmployeeList.add(tempEmp);
            tempNode = new EmployeeNode(tempEmp.getfName(), tempEmp.getsName(), tempEmp.getEmployeeRole(), tempEmp.getRepTo());
            nodeList.put(tempEmp.getfName(), tempNode);
        }

        Scanner scanner = new Scanner(System.in);

        //  prompt for the users input
        String userOptions = "Functions Available: \n 1, Search Employee Details by Name \n" +
                "2, Search Employees Older Than a Specific Date \n" +
                "3, View Orginizational Structure \n" +
                "4, View Highest Earning Employees \n";
        System.out.print(userOptions);

        // get their input as a String
        String option = scanner.next();
        System.out.println("You have selected Option: " + option + "\n");

        //switch based upon input
        switch(option){
            case "1":
                System.out.println("Please Enter the Employee's Name Which You Wish to Search: ");
                option = scanner.next().toLowerCase();
                function.printSearchedForEmployee(option, EmployeeList);
                break;
            case "2":
                System.out.println("Please Enter the Date You Wish To Search From: Format(dd-MM-yyyy) \n ");
                option = scanner.next();
                Date startDate = null;
                try {
                    startDate = formatter.parse(option);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String toPrint = function.getEmployeesOlderThanSpecifiedDateToString(startDate);
                System.out.println(toPrint);
                break;

            case "3":
                List<String> managerList = new ArrayList<String>();
                String name = "";
                String reportingTo = "";
                List<String> reportToList = new ArrayList<String>();
                for(int x = 0; x < Main.EmployeeList.size() ; x++){
                    name = Main.EmployeeList.get(x).getfName();
                    for(int y = 0 ; y < Main.EmployeeList.size() ; y++){
                        reportingTo = Main.EmployeeList.get(y).getRepTo();
                        if(name.equals(reportingTo) ){
                            reportToList.add(Main.EmployeeList.get(y).getfName());
                        }
                    }
                    List<String> tempCopy = new ArrayList<String>(reportToList);
                    reportToMap.put(name, tempCopy );
                    reportToList.clear();
                }
                for(int x = 0 ; x < EmployeeList.size() ; x++){
                    if(EmployeeList.get(x).getEmployeeRole().equals("Manager")){
                        managerList.add(EmployeeList.get(x).getfName());
                    }
                }


                for(int x = 0 ; x < managerList.size() ; x++){
                    tempNode = nodeList.get(managerList.get(x));
                    function.buildHierarcyTree(tempNode);
                    function.printHierarcyTree(tempNode, 0);
                }

                break;
            case "4":
                String output = "The highest earning member on each tier level is:\n\n";
                output += function.getHigestEarningManager(EmployeeList) + "\n\n";
                output += function.getHigestEarningEmployee(EmployeeList) + "\n\n";
                output += function.getHigestEarningTrainee(EmployeeList) + "\n\n";
                System.out.println(output);
                break;
            default:
                System.out.println(("Not a valid option!\n"));
                break;
        }
    }

}
