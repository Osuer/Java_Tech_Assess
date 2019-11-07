import java.util.ArrayList;
import java.util.List;

//Maybe kan my employeeNode by my Employee inherit?

public class EmployeeNode{
    String reportsTo = "";
    String name = "";
    String surname = "";
    String role = "";
    List<EmployeeNode> children = new ArrayList<EmployeeNode>();

    public EmployeeNode(String n, String s, String r, String report){
        name = n;
        surname = s;
        role = r;
        reportsTo = report;
        children = null;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeNode(EmployeeNode n){
        name = n.getName();
        role = n.getRole();
        surname = n.getSurname();
        reportsTo = n.getReportsTo();
        children = n.getChildren();
    }

    public void setChildren(List<EmployeeNode> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
    public String getReportsTo() {
        return reportsTo;
    }

    public List<EmployeeNode> getChildren() {
        return children;
    }


}
