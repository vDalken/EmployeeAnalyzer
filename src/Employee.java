class Employee {
    private final String name;
    private final int yearsAtDepartment;
    private final int age;
    private final int yearlySalary;

    public Employee(String name, int yearsAtDepartment, int age, int yearlySalary) {
        this.name = name;
        this.yearsAtDepartment = yearsAtDepartment;
        this.age = age;
        this.yearlySalary = yearlySalary;
    }

    public String getName() {
        return name;
    }

    public int getYearsAtDepartment() {
        return yearsAtDepartment;
    }

    public int getAge() {
        return age;
    }

    public int getYearlySalary() {
        return yearlySalary;
    }
}
