import java.util.Stack;

public class P2<T> {
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		//mq.push(1);
		//mq.push(2);
		//mq.push(3);
		System.out.println(mq.pop());
		System.out.println(mq.peek());
		System.out.println(mq.isEmpty());
		
	}
	
	public static class MyQueue{
		public Stack<Integer> in;
		public Stack<Integer> out;
		
		public MyQueue() {
			this.in = new Stack<Integer>();
			this.out = new Stack<Integer>();
		}
		
		public void push(int obj) {
			in.push(obj);
		}
		
		public int pop() {
			if(out.isEmpty()) {
				while(!in.isEmpty()) {
					out.push(in.pop());
				}
			}
			return out.pop();
		}
		
		public int peek() {
			if(out.isEmpty()) {
				while(!in.isEmpty()) {
					out.push(in.pop());
				}
			}
			return out.peek();
		}
		
		public boolean isEmpty() {
			return in.isEmpty() && out.isEmpty();
		}
	}
}
