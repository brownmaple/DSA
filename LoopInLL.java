package generalPrograms;

import java.util.HashSet;

/* Using Hashing technique*/

public class LoopInLL {
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			next = null;
		}
	}
	
	public static Boolean findLoop(Node root) {
		HashSet<Node> nodeSet = new HashSet<LoopInLL.Node>();
		if(root != null) {
			while(root != null) {
				if(!nodeSet.contains(root)) {
					nodeSet.add(root);
				}
				else {
					return true;
				}
				root = root.next;
			}
			return false;
		}
		else
			return false;
	}
	
	public static void removeLoop(Node root) {
		System.out.println("remove loop started");
		HashSet<Node> nodeSet = new HashSet<LoopInLL.Node>();
		if(root != null) {
			Node ptr1 = null;
			Node ptr2 = root;
			while(ptr2 !=null) {
				if(!nodeSet.contains(ptr2)) {
					nodeSet.add(ptr2);
					ptr1 = ptr2;
					ptr2 = ptr2.next;
				}
				else {
					ptr1.next = null;
					ptr2 = null;
				}
			}
		}
		else {
			System.out.println("Invalid root node");
		}
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
		if(findLoop(n1)) {
			System.out.println("loop exists, so removing it");
			removeLoop(n1);
			System.out.println("loop removed");
		}
		if(findLoop(n1))
			System.out.println("remove loop failed");
		else
			System.out.println("remove loop success");
	}
}
