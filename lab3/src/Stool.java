class Stool extends Chair {
    public Stool(String material) {
        super(material);
    }

    @Override
    public void print() {
        System.out.println("Табуретка сделана из: " + material);
    }

    @Override
    public void use() {
        System.out.println("*Сидение за табуреткой*");
    }
}