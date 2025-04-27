public class Employee {
    private final String lastName;
    private final double salary;
    private final boolean hasChildren;

    public Employee() {
        this.lastName = "Неизвестно";
        this.salary = 0.0;
        this.hasChildren = false;
    }

    public Employee(String lastName, double salary, boolean hasChildren) {
        this.lastName = lastName;
        this.salary = salary;
        this.hasChildren = hasChildren;
    }

    public Employee(String lastName, double salary) {
        this.lastName = lastName;
        this.salary = salary;
        this.hasChildren = false;
    }

    public void printEmployeeInfo() {
        System.out.println("Фамилия: " + getLastName());
        System.out.println("Зарплата: " + getSalary());
        System.out.println("Наличие детей: " + (hasChildren()? "Да" : "Нет"));
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public boolean hasChildren() {
        return hasChildren;
    }
}