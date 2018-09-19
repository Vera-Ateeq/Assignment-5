import java.util.Stack;

public class P4 {
	public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.peek());
	}
	
	public static class MinStack{
		public Stack<Integer> s;
		public int minEl;
		
		public MinStack() {
			this.s = new Stack<Integer>();
		}
		
		public void push(int obj) {
			if(s.isEmpty()) {
				s.push(obj);
				minEl = obj;
			}else if(obj <= minEl) {
				s.push((2*obj )- minEl);
				minEl = obj;
			}else {
				s.push(obj);
			}
		}
		
		public int pop() {
			if(s.size() < 1) {
				System.out.println("Stack is empty");
				return 1000;
			}
			int temp = minEl;
			if(s.peek() < minEl) {
				minEl = 2*minEl - s.pop();
				return temp;
			}else {
				return s.pop();
			}
		}
		
		public int getMin() {
			if(s.size() < 1) {
				System.out.println("Stack is empty");
				return 1000;
			}
			return minEl;
		}
		
		public int peek() {
			if(s.size() < 1) {
				System.out.println("Stack is empty");
				return 1000;
			}
			if(s.peek() < minEl) {
				return minEl;
			}else {
				return s.peek();
			}
		}
		
		public boolean isEmpty() {
			return s.isEmpty();
		}
	}
}
