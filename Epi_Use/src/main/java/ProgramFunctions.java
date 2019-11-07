import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProgramFunctions {

    // ================================ QUESTION 1 ==============================
    public String printSearchedForEmployee(String name){
        boolean nameFound = false;
        String toReturn = "";
        name = name.toLowerCase();
        for( int x = 0; x < Main.EmployeeList.size() ; x++){
            if(Main.EmployeeList.get(x).getfName().toLowerCase().equals(name) ){
                toReturn += Main.EmployeeList.get(x).toString();
                nameFound = true;
                break;
            }
        }
        if(!nameFound)
            toReturn += "This employee name could not be found!";

        return toReturn;
    }
    // ============================= QUESTION 2 =================================
    public String getEmployeesOlderThanSpecifiedDateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String toReturn = "";
        boolean isOlder = false;
        Date tempDate = new Date();
        for( int x = 0; x < Main.EmployeeList.size() ; x++){
            tempDate = Main.EmployeeList.get(x).getEmployeeDoB();
            if(tempDate.compareTo(date) < 0  ){
                isOlder = true;
                toReturn += Main.EmployeeList.get(x).toString()+"\n\n";
            }
        }
        if(!isOlder){
            toReturn += "There are no employees older than the date: " + formatter.format(date);
        }
        return toReturn;
    }

    //================================ QUESTION 4 =======================================
    // Is nie seker of 3 seperate functions beter is as almal in een function nie?
    // Ook nie seker of is dit beter om die List te pass as param of net static list te gebruik nie?
    public String getHigestEarningManager(ArrayList<Employee> list) throws ParseException {
        NumberFormat formatDouble = new DecimalFormat("#000,000.00");
        Employee tempEmp;
        String toReturn = "";
//        EmployeeSalaryComparator compare = new EmployeeSalaryComparator();
//        Collections.sort(list, compare);
        for(int x = 0 ; x < list.size() ; x++ ){
            if(list.get(x).getEmployeeRole().equals("Manager")){
                tempEmp = new Employee(list.get(x));
                toReturn += "Managers: " + tempEmp.getfName() + " " + tempEmp.getsName() + " - R " + formatDouble.format(tempEmp.getEmployeeSalary());
                break;
            }
        }
        return toReturn;
    }
    //================================ QUESTION 4 =======================================
    public String getHigestEarningEmployee(ArrayList<Employee> list) throws ParseException {
        NumberFormat formatDouble = new DecimalFormat("#000,000.00");
        Employee tempEmp;
        String toReturn = "";
//        EmployeeSalaryComparator compare = new EmployeeSalaryComparator();
//        Collections.sort(list, compare);
        for(int x = 0 ; x < list.size() ; x++ ){
            if(list.get(x).getEmployeeRole().equals("Employee")){
                tempEmp = new Employee(list.get(x));
                toReturn += "Employees: " + tempEmp.getfName() + " " + tempEmp.getsName() + " - R " + formatDouble.format(tempEmp.getEmployeeSalary());
                break;
            }
        }
        return toReturn;
    }
    //================================ QUESTION 4 =======================================
    public String getHigestEarningTrainee(ArrayList<Employee> list) throws ParseException {
        NumberFormat formatDouble = new DecimalFormat("#000,000.00");
        Employee tempEmp;
        String toReturn = "";
//        EmployeeSalaryComparator compare = new EmployeeSalaryComparator();
//        Collections.sort(list, compare);
        for(int x = 0 ; x < list.size() ; x++ ){
            if(list.get(x).getEmployeeRole().equals("Trainee")){
                tempEmp = new Employee(list.get(x));
                toReturn += "Trainees: " + tempEmp.getfName() + " " + tempEmp.getsName() + " - R " + formatDouble.format(tempEmp.getEmployeeSalary());
                break;
            }
        }
        return toReturn;
    }

    //============================================== QUESTION 3 ======================================
    public void buildHierarcyTree(EmployeeNode root){
        EmployeeNode emp = root;
        List<EmployeeNode> children = getChildrenByName(emp.getName());
        emp.setChildren(children);

        if(children.size() == 0){
            return;
        }

        for (EmployeeNode e : children){
            buildHierarcyTree(e);
        }
    }

    //============================================== QUESTION 3 ======================================

    //Test kan hier geskryf word vir output?

    public void printHierarcyTree(EmployeeNode root, int level){
        EmployeeNode emp = root;
        String l = "";
        for(int x = 0 ; x < level ; x++)
            l += "\t";
        if (level == 0){
            l +=  root.getName() + " " + root.getSurname()+ " (" + root.getRole() + ")\n" ;
        }else{
            l += "--> " + root.getName() + " " + root.getSurname()+ " (" + root.getRole() + ")\n" ;
        }
        for(int x = 0 ; x < level  ; x++)
            l += "\t";
        l += "|\n";
        for(int y = 0 ; y < level  ; y++)
            l += "\t";
        l += "|";

        System.out.println(l);
        List<EmployeeNode> children = root.getChildren();
        for (EmployeeNode e : children){
            printHierarcyTree(e, level+1);
        }
    }

    //============================================== QUESTION 3 ======================================
    public List<EmployeeNode> getChildrenByName(String n){
        List<EmployeeNode> toReturn = new ArrayList<EmployeeNode>();
        String nameToMakeNodeOf;
        for( int x = 0 ; x < Main.reportToMap.get(n).size() ; x++){
            nameToMakeNodeOf = Main.reportToMap.get(n).get(x);
            toReturn.add(Main.nodeList.get(nameToMakeNodeOf));
        }
        return toReturn;
    }
}
