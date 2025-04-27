class BarStool extends Chair {
    public BarStool(String material) {
        super(material);
    }

    @Override
    public void print() {
        System.out.println("Барный стул сделан из: " + material);
    }

    @Override
    public void use() {
        System.out.println("*Сидение на барном стуле*");
    }
}