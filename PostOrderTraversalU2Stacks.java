package generalPrograms;

import java.util.Stack;

public class PostOrderTraversalU2Stacks {
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

    public Stack<Node> postOrderTraversal(Node root){
        Stack<Node> firstStack = new Stack<>();
        Stack<Node> secondStack = new Stack<>();

        if(root == null)
            return secondStack;

        firstStack.push(root);
        while(!firstStack.isEmpty()){
            Node temp = firstStack.pop();
            secondStack.push(temp);
            if(temp.left != null)
                firstStack.push(temp.left);
            if(temp.right != null)
                firstStack.push(temp.right);
        }
        return secondStack;
    }

    public void reverseStack(Stack<Node> s){
        Node top = s.pop();
        if(!s.isEmpty())
            reverseStack(s);
        System.out.print(top.data+" ");
    }

    public static void main(String[] args) {
        PostOrderTraversalU2Stacks potr = new PostOrderTraversalU2Stacks();
        PostOrderTraversalU2Stacks.Node n1 = potr.new Node(1);
        PostOrderTraversalU2Stacks.Node n2 = potr.new Node(2);
        PostOrderTraversalU2Stacks.Node n3 = potr.new Node(3);
        PostOrderTraversalU2Stacks.Node n4 = potr.new Node(4);
        PostOrderTraversalU2Stacks.Node n5 = potr.new Node(5);
        PostOrderTraversalU2Stacks.Node n6 = potr.new Node(6);
        PostOrderTraversalU2Stacks.Node n7 = potr.new Node(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        Stack<Node> res = potr.postOrderTraversal(n1);
        while(!res.isEmpty()){
            System.out.print(res.pop().data + " ");
       }
    }
}
