import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHasSetTest2 {

    public static void main(String[] args) {

        Set<Integer> set = new LinkedHashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(50);
        set.add(40);
        set.add(10);   // Duplicate - ignored

        System.out.println(set);

        set.remove(30);   // Removes value 30
        System.out.println(set);

        // Enhanced for loop
        for (Integer i : set) {
            System.out.println(i);
        }

        // Using Iterator
        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}