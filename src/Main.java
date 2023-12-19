import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Department HumanResources = new Department(generateRandomListOfEmployees());
        Department CustomerService = new Department(generateRandomListOfEmployees());
        int numberOfEmployeesWithExperienceOver30 = countEmployeesWithExperienceGreaterThan(
                HumanResources, 30);
        List<String> namesOfEmployeesWithYearlySalaryOver30000 = new ArrayList<>(findEmployeesWithSalaryOver(CustomerService, 30000));
        List<Employee> employeesOlderThan45 = new ArrayList<>(getEmployeesOlderThan(CustomerService, 45));
        Employee firstEmployeeOlderThan36 = findFirstEmployeeOlderThan(HumanResources, 29);
        OptionalDouble averageSalaryInHR = getAverageDepartmentSalary(HumanResources);
        List<String> commonNamesInBothDepartments = getCommonNames(HumanResources, CustomerService);
        int age=6;
    }

    private static String generateRandomName(final Random random) {
        final ArrayList<String> randomNames = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack",
                "Katherine", "Liam", "Mia", "Noah", "Olivia", "Peter", "Quinn", "Rachel", "Samuel", "Taylor",
                "Ursula", "Vincent", "Wendy", "Xavier", "Yvonne", "Zane", "Abigail", "Benjamin", "Chloe", "Daniel",
                "Emily", "Finn", "Gabriella", "Harrison", "Isabella", "Jacob", "Kylie", "Lucas", "Madison", "Nathan",
                "Oliver", "Penelope", "Quentin", "Rebecca", "Sophia", "Thomas", "Uma", "Victor", "Willow",
                "Xander", "Yasmine", "Zachary", "Ava", "Bryce", "Cora", "Dylan", "Eleanor", "Felix", "Georgia",
                "Hazel", "Isaac", "Jasmine", "Kai", "Lily", "Mason", "Nora", "Oscar", "Piper", "Quincy",
                "Riley", "Scarlett", "Theodore", "Ulysses", "Violet", "Wyatt", "Xena", "Yara", "Zara",
                "Aaron", "Bella", "Caleb", "Daisy", "Elijah", "Fiona", "George", "Harper", "Isla", "Jaxon")
        );
        return randomNames.get(random.nextInt(randomNames.size()));
    }

    private static int generateRandomYearsAtDepartment(final Random random) {
        return random.nextInt(61);
    }

    private static int generateRandomAge(final Random random) {
        return random.nextInt(60) + 20;
    }

    private static int generateRandomYearlySalary(final Random random) {
        return random.nextInt(15000) + 15000;
    }

    private static ArrayList<Employee> generateRandomListOfEmployees() {
        Random random = new Random();
        final ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            employees.add(new Employee(generateRandomName(random), generateRandomYearsAtDepartment(random), generateRandomAge(random), generateRandomYearlySalary(random)));
        }
        return employees;
    }

    private static int countEmployeesWithExperienceGreaterThan(final Department department, final int experience) {
        return (int) department
                .getEmployees()
                .stream()
                .filter(employee -> employee.getYearsAtDepartment() > experience)
                .count();
    }

    private static List<String> findEmployeesWithSalaryOver(final Department department, final int salary) {
        return department
                .getEmployees()
                .stream()
                .filter(employee -> employee.getYearlySalary() > salary)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    private static List<Employee> getEmployeesOlderThan(final Department department, int age) {
        return department
                .getEmployees()
                .stream()
                .filter(employee -> employee.getAge() > age)
                .toList();

    }

    private static Employee findFirstEmployeeOlderThan(final Department department, int age) {
        return  department
                .getEmployees()
                .stream()
                .filter(employee -> employee.getAge() > age)
                .findFirst()
                .orElse(null);
    }

    private static OptionalDouble getAverageDepartmentSalary(Department department) {
        return department
                .getEmployees()
                .stream()
                .mapToInt(Employee::getYearlySalary)
                .average();
    }

    private static List<String> getCommonNames(Department firstDepartment, Department secondDepartment) {
        List<String> namesOfFirstDepartment = firstDepartment.getEmployees().stream().map(Employee::getName).toList();
        List<String> namesOfSecondDepartment = secondDepartment.getEmployees().stream().map(Employee::getName).toList();
        return namesOfFirstDepartment
                .stream()
                .distinct()
                .filter(namesOfSecondDepartment::contains)
                .toList();
    }
}