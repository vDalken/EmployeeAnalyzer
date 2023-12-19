import java.util.ArrayList;

class Department {
    private final ArrayList<Employee> employees;

    public Department(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
