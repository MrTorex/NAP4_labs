class Driver extends Employee {
    public Driver(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " ведёт поезд.");
    }
}