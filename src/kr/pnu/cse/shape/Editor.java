package kr.pnu.cse.shape;

import java.util.List;
import java.util.ArrayList;

public class Editor {
    private List<Object> shapes = new ArrayList<>();

    public void add(Object newObject) {
        shapes.add(newObject);
    }

    public void clear() {
        shapes.clear();
    }

    public void list() {
        if (shapes.size() == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print('[');
        int i = 0;
        while(i < shapes.size() - 1) {
            System.out.print(shapes.get(i) + ", ");
            i++;
        }
        System.out.print(shapes.get(i) + "]");
        System.out.println();
    }
}
