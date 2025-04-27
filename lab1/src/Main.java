public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Иванов", 50000, true);
        Employee emp2 = new Employee("Петров", 45000);
        Employee emp3 = new Employee();

        WriterInfo writer = new WriterInfo();

        writer.printEmployeeInfo(emp1);
        writer.printEmployeeInfo(emp2);
        writer.printEmployeeInfo(emp3);
    }
}