package generalPrograms;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalRecursion {
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public void setRight(Node right){
            this.right = right;
        }
        public Node getLeft(){
            return this.left;
        }
        public Node getRight(){
            return this.right;
        }
    }

    public ArrayList<Integer> postOrderTraversal(Node root){
        Stack<Node> travelStack = new Stack<>();
        travelStack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        Node prev = null;
        if(root == null)
            return res;
        while(!travelStack.isEmpty()){
               Node curr = travelStack.peek();
                if(prev == null || prev.right == curr || prev.left == curr){
                    if(curr.left != null)
                        travelStack.push(curr.left);
                    else if(curr.right!=null)
                        travelStack.push(curr.right);
                    else {
                        Node leaf = travelStack.pop();
                        res.add(leaf.data);
                    }
                }
                if(curr.left == prev){
                    if(curr.right != null)
                        travelStack.push(curr.right);
                }

                if(curr.right == prev){
                    res.add(travelStack.pop().data);
                }
                prev = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        PostOrderTraversalRecursion potr = new PostOrderTraversalRecursion();
        PostOrderTraversalRecursion.Node n1 = potr.new Node(1);
        PostOrderTraversalRecursion.Node n2 = potr.new Node(2);
        PostOrderTraversalRecursion.Node n3 = potr.new Node(3);
        PostOrderTraversalRecursion.Node n4 = potr.new Node(4);
        PostOrderTraversalRecursion.Node n5 = potr.new Node(5);
        PostOrderTraversalRecursion.Node n6 = potr.new Node(6);
        PostOrderTraversalRecursion.Node n7 = potr.new Node(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println(potr.postOrderTraversal(n1).toString());
    }
}
