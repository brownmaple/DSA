package generalPrograms;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeBFS {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
			left = null;
			right = null;
		}
	}
	
	public static String IsSymmetric(Node root) {
		if(root == null || root.left ==null || root.right ==null)
			return "false1";
		Queue<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		while(!q.isEmpty()) {
			Node left = q.remove();
			Node right = q.remove();
			if(left!=null && right!=null)
			{
				if(left.data == right.data) 
				{
					q.add(left.left);
					q.add(right.right);
					q.add(left.right);
					q.add(right.left);
				}
				else {
					return "false2";
				}
			}
		}
		return "true1";
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(5);
		Node n7 = new Node(3);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		System.out.println(IsSymmetric(n1));
	}

}
