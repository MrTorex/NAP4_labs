import java.util.ArrayList;
import java.util.List;

class Train {
    private final List<Employee> staff;

    public Train() {
        staff = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        staff.add(employee);
    }

    public void showStaffWork() {
        for (Employee employee : getStaff()) {
            employee.work();
        }
    }

    public List<Employee> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "Train{" +
                "staff=" + getStaff() +
                '}';
    }
}