package designpatterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates Iterator usage and removal during iteration.
 */
public class IteratorOps {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(11);
        
        Iterator<Integer> it = arr.listIterator();
        
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
