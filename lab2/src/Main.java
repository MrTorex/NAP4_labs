public class Main {
    public static void main(String[] args) {
        Train train = new Train();

        Driver driver = new Driver("Иван Колбас", 1);
        Conductor conductor = new Conductor("Антон Закревский", 2);
        Mechanic mechanic = new Mechanic("Артём Ковальчук", 3);

        train.addEmployee(driver);
        train.addEmployee(conductor);
        train.addEmployee(mechanic);

        train.showStaffWork();

        System.out.println(train);

        Employee employee1 = new Driver("Иван Колбас", 1);
        Employee employee2 = new Driver("Иван Колбас", 1);

        System.out.println("employee1.equals(employee2): " + employee1.equals(employee2));
        System.out.println("employee1.hashCode(): " + employee1.hashCode());
        System.out.println("employee2.hashCode(): " + employee2.hashCode());
    }
}