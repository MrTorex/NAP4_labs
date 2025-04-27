class Wardrobe implements Object, Furniture {
    private final String type;

    public Wardrobe(String type) {
        this.type = type;
    }

    @Override
    public void print() {
        System.out.println("Тип шкафа: " + type);
    }

    @Override
    public void use() {
        System.out.println("*Хранение вещей в гардеробе*");
    }
}