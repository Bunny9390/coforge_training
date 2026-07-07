import java.util.Map;
import java.util.Set;

public class TreeMap {

	public static void main(String[] args) {

		java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();

		map.put(101, "Bunny");
		map.put(102, "Rahul");
		map.put(103, "Ravi");
		map.put(5, "hello");
		map.put(5, "hola"); // Updates the value

		System.out.println(map);

		System.out.println(map.remove(102));

		System.out.println(map.get(103));

		// Traverse using keySet()
		Set<Integer> keys = map.keySet();

		for (int key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}

		// Traverse using entrySet()
		Set<Map.Entry<Integer, String>> entries = map.entrySet();

		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}