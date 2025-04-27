import java.util.Objects;

abstract class Chair implements Object, Furniture {
    protected String material;

    public Chair(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Стул сделан из: " + material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chair chair = (Chair) obj;
        return Objects.equals(material, chair.material);
    }
}