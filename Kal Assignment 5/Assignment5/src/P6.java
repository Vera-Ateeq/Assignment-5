import java.util.LinkedList;
import java.util.Queue;

public class P6 {
	public static void main(String[] args) {
		String s = "aabbc";
		nonRepeating(s);
	}
	
	public static void nonRepeating(String s) {
		s.toLowerCase();
		Queue<Character> q = new LinkedList<Character>();
		int[] count = new int[26];
		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			q.add(s.charAt(i));
			while(!q.isEmpty()) {
				if(count[s.charAt(i) - 'a'] > 1) {
					q.remove();
				}else {
					System.out.print(q.peek() + " ");
				}
			}
			if(q.isEmpty()) {
				System.out.print("-1 ");
			}
		}

		System.out.println(" ");

	}
}
