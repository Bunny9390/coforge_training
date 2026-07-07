import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;

public class TreeSet {

    public static void main(String[] args) {

        SortedSet<Integer> set = new java.util.TreeSet<>(Collection.reverseorder);

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(50);
        set.add(40);
        set.add(10); // Duplicate ignored

        System.out.println(set);

        set.remove(30); // Remove value 30
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

        // SortedSet methods
        System.out.println("First : " + set.first());
        System.out.println("Last : " + set.last());
        System.out.println("HeadSet : " + set.headSet(40));
        System.out.println("TailSet : " + set.tailSet(20));
        System.out.println("SubSet : " + set.subSet(20, 50));
    }
}