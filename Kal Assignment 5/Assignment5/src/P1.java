import java.util.Stack;

public class P1 {

	public static void main(String[] args) {
		int[]  nums = {4,5,2,25,30};
		nextGreatElement(nums);
	}
	
	public static void nextGreatElement (int[] nums) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(nums[0]);
		for(int i = 1; i < nums.length; i++) {
				while(!st.isEmpty() && nums[i] > st.peek()) {
					if(nums[i] > st.peek()) {
						System.out.println(st.pop()+ "--> " + nums[i]);
					}
				}			
				st.push(nums[i]);		
		}
		while(!st.isEmpty()) {
			System.out.println(st.pop()+ "--> -1");
		}	
	}
}
