import java.util.LinkedList;
import java.util.Queue;

public class P3 {
	public static void main(String[] args) {
		MyStack mq = new MyStack();
		mq.push(1);
		mq.push(2);
		mq.push(3);
		System.out.println(mq.pop());
		System.out.println(mq.peek());
		System.out.println(mq.isEmpty());
		mq.push(4);
		System.out.println(mq.pop());
		System.out.println(mq.peek());

	}
	
	public static class MyStack{
		public Queue<Integer> q1;
		public Queue<Integer> q2;
		
		public MyStack() {
			this.q1 = new LinkedList<Integer>();
			this.q2 = new LinkedList<Integer>();
		}
		
		public void push(int obj) {
			if(q1.isEmpty()) {
				q2.add(obj);
			}else if(q2.isEmpty()) {
				q1.add(obj);
			}
		}
		
		public int pop() {
			if(q1.isEmpty()) {
				for(int i = 0; i < q2.size(); i++) {
					q1.add(q2.poll());
				}
				return q2.poll();
			}else {
				for(int i = 0; i < q1.size(); i++) {
					q2.add(q1.poll());
				}
				return q1.poll();
			}
		}
		
		public int peek() {
			int temp;
			if(q1.isEmpty()) {
				for(int i = 0; i < q2.size(); i++) {
					q1.add(q2.poll());
				}
				temp = q2.poll();
				q1.add(temp);
				return temp;
			}else {
				for(int i = 0; i < q1.size(); i++) {
					q2.add(q1.poll());
				}
				temp = q1.poll();
				q2.add(temp);
				return temp;
			}
		}
		
		public boolean isEmpty() {
			return q1.isEmpty() && q2.isEmpty();
		}
	}
}
