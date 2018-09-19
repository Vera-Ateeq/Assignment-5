import java.util.HashMap;
import java.util.LinkedList;

public class P5 {
	public static void main(String[] args) {
		Node w1 = new Node("1", "1 result");
		Node w2 = new Node("2", "2 result");
		Node w3 = new Node("3", "3 result");
		Node w4 = new Node("4", "4 result");

		
		LRU cache = new LRU(2);
		cache.set(w1.key, w1);
		cache.set(w2.key, w2);
		cache.get("1");       // returns 1
		cache.set(w3.key, w3);    // evicts key 2
		cache.get("2");       // returns -1 (not found)
		cache.set(w4.key, w4);    // evicts key 1
		cache.get("1");       // returns -1 (not found)
		cache.get("3");       // returns 3
		cache.get("4");   //4
	}
	
	public static class LRU{
		public int capacity;
		public int count;
		public HashMap<String, Node> hm;
		public LinkedList<Node> ll;
		
		public LRU(int capacity) {
			this.capacity = capacity;
			this.count = 0;
			this.hm = new HashMap <String, Node>();
			this.ll = new LinkedList <Node>();
		}
		
		public int get(String s) {
			if(hm.containsKey(s)) {
				System.out.println(s + "'s result: " + hm.get(s).result);
				ll.remove(hm.get(s));
				ll.addFirst(hm.get(s));
				return 1;
			}else {
				System.out.println(s + " is not available");
				return -1;
			}
		}
		
		public void set(String search, Node result) {
			if(count < capacity) {
				hm.put(search, result);
				ll.addFirst(result);
				count++;
			}else {
				Node toRemove = ll.removeLast();
				hm.remove(toRemove.key);
				hm.put(search, result);
				ll.addFirst(result);
			}
		}
	}
	
	public static class Node{
		public String key;
		public String result; 
		
		public Node (String keyword, String data) {
			this.key = keyword;
			this.result = data;
		}
	}
}
