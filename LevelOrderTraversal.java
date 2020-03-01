package generalPrograms;

import java.util.LinkedList;

public class LevelOrderTraversal {

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

    public void traversal(Node root){
        LinkedList<Node> lln = new LinkedList<>();
        lln.add(root);

        while(!lln.isEmpty()){
            Node front = lln.removeFirst();
            System.out.print(front.data+" ");
            if(front.left!=null)
                lln.add(front.left);
            if(front.right!=null)
                lln.add(front.right);
        }
    }
    public static void main(String[] args) {
        LevelOrderTraversal potr = new LevelOrderTraversal();
        LevelOrderTraversal.Node n1 = potr.new Node(1);
        LevelOrderTraversal.Node n2 = potr.new Node(2);
        LevelOrderTraversal.Node n3 = potr.new Node(3);
        LevelOrderTraversal.Node n4 = potr.new Node(4);
        LevelOrderTraversal.Node n5 = potr.new Node(5);
        LevelOrderTraversal.Node n6 = potr.new Node(6);
        LevelOrderTraversal.Node n7 = potr.new Node(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        //n3.setRight(n7);
        potr.traversal(n1);
    }
}
