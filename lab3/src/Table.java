class Table implements Object, Furniture {
    private final String shape;

    public Table(String shape) {
        this.shape = shape;
    }

    @Override
    public void print() {
        System.out.println("Форма стола: " + shape);
    }

    @Override
    public void use() {
        System.out.println("*Работа за столом*");
    }
}