class Mechanic extends Employee {
    public Mechanic(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " чинит поезд.");
    }
}