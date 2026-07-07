import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap<Integer, String> map = new HashMap<>();
		 
		 map.put(101, "Bunny");
		 map.put(102, "Rahul");
	     map.put(103, "Ravi");
	     map.put(5, "hello");
	     map.put(5, "hola");
	     
	     System.out.println(map);
	     
	     System.out.println(map.remove(102));
	     
	     System.out.println(map.get(103));
	     
	     Set<Integer> keys = map.keySet();
	     for(int key : keys) {
	    	 System.out.println(key + "->" + map.get(key));
	     }
	     
	     Set<Entry<Integer,String>> entries = map.entrySet();
	     for(Entry<Integer,String> entry : entries) {
	    	 System.out.println(entry.getKey() + "->" + entry.getValue)
	     }
	    
		 

	}

}
