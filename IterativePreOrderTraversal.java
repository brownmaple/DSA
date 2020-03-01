package generalPrograms;

import java.util.Stack;

public class IterativePreOrderTraversal {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	
	public static void PrintPreOrder(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			Node curr = s.pop();
			System.out.print(curr.data+" ");
			if(curr.right!=null)
				s.push(curr.right);
			if(curr.left!=null)
				s.push(curr.left);
		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		PrintPreOrder(n1);
	}
}
