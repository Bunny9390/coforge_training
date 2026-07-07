import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AsSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ArrayList<Integer> list = new ArrayList<>(); // no DMD
		Set<Integer> set = new HashSet<>(); // dynamic memory dispatch

		set.add(new Integer(10)); // boxing
		set.add(20); // Auto Boxing
		set.add(30);
		set.add(50);
		set.add(40);
		set.add(10);
		System.out.println(set);
//		System.out.println(set.get(3));
		
		set.remove(3); //remove
		System.out.println(set);
		
//		set.set(2,10); //update
//		System.out.println(set);
//		
		//traversing the list
//		for(int i=0;i<set.size();i++) { 
//			System.out.println(set.get(i));
//		}
		
		//enhanced for loop
		for(Integer i : set) {
			System.out.println(i);
		}
		
		//using iterator
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
