package generalPrograms;
public class ReverseLLIteration {
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
		}
	}
	
	public static Node reverse(Node root) {
		Node prev = null;
		Node curr = root;
		Node next = null;
		while(curr.next!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		curr.next = prev;
		return curr;
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
		n5.next = null;
		Node newHead = reverse(n1);
		while(newHead.next!=null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}
}
