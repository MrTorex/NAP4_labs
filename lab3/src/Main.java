import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> furniture = new ArrayList<>();
        furniture.add(new Stool("дерево"));
        furniture.add(new BarStool("металл"));
        furniture.add(new Wardrobe("для одежды"));
        furniture.add(new Table("круглый"));

        for (Object item : furniture) {
            item.print();
            ((Furniture) item).use();
            System.out.println(item);
            System.out.println("Хэш: " + item.hashCode());
            System.out.println();
        }

        Stool stool = new Stool("дерево");
        BarStool barStool = new BarStool("металл");

        System.out.println("Проверка равенства объектов: " + stool.equals(barStool));
    }
}
