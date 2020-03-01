package generalPrograms;

public class LoopInLLFloyd {
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			next = null;
		}
	}
	
	public static void checkLoop(Node root) {
		Node sp = root;
		Node fp = root;
		while(sp!=null && fp!=null && fp.next!=null) {
			sp = sp.next;
			fp = fp.next.next;
			if(sp==fp) {
				System.out.println("loop exists");
				breakLoop(sp,root);
				System.out.println("loop broken");
				break;
			}
		}
	}
	
	public static void breakLoop(Node meet, Node root) {
		System.out.println("breaking loop");
		Node ptr1, ptr2;
		ptr1 = root;
		while(1==1) {
			ptr2 = meet;
			while(ptr2.next!=ptr1 && ptr2.next!=meet) {
				ptr2 = ptr2.next;
			}
			if(ptr2.next == ptr1) {
				break;
			}
			ptr1 = ptr1.next;
		}
		ptr2.next = null;
	}
 public static void main(String[] args) {
	 	Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		checkLoop(n1);
		System.out.println("check again if loop exists");
		checkLoop(n1);
 }
}
