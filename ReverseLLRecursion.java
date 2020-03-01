package generalPrograms;

public class ReverseLLRecursion {
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
		}
	}
	
	public static Node reverseLL(Node root) {
		if(root == null)
			return null;
		if(root.next==null)
			return root;
		Node newHead = reverseLL(root.next);
		root.next.next = root;
		root.next = null;
		return newHead;
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
		
		Node ref1 = n1;
		Node ref2 = n1;
		
		while(ref1.next!=null) {
			System.out.println(ref1.data);
			ref1 = ref1.next;
		}
		System.out.println(ref1.data);
		System.out.println("performing reverse");
		Node head = reverseLL(ref2);
		while(head.next!=null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(ref2.data);
	}

}
