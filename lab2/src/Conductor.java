class Conductor extends Employee {
    public Conductor(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println(getName() + " проверяет билеты.");
    }
}