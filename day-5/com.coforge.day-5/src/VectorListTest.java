import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ArrayList<Integer> list = new ArrayList<>(); // no DMD
		List<Integer> list = new Vector<>(); // dynamic memory dispatch

		list.add(new Integer(10)); // boxing
		list.add(20); // Auto Boxing
		list.add(30);
		list.add(50);
		list.add(40);
		System.out.println(list);
		System.out.println(list.get(3));
		
		list.remove(3); //remove
		System.out.println(list);
		
		list.set(2,10); //update
		System.out.println(list);
		
		//traversing the list
		for(int i=0;i<list.size();i++) { 
			System.out.println(list.get(i));
		}
		
		//enhanced for loop
		for(Integer i : list) {
			System.out.println(i);
		}
		
		//using iterator
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//enumaration in vector
		Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");
        Enumeration<String> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
	}

}
