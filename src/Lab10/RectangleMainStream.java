package Lab10;

import java.util.List;
import java.util.ArrayList;

public class RectangleMainStream {
    public static void main(String[] args) {
        List<Rectangle> list0 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Rectangle r = new Rectangle(i + 10, i + 10);
            list0.add(r);
        }

        // A single statement with Stream API
        list0.stream()
                .filter(r -> r.getArea() >= 200)
                .filter(r -> r.getWidth() % 2 == 0)
                .map(r -> r.getName().toUpperCase())
                .forEach(System.out::println);
    }
}
