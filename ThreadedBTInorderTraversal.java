package generalPrograms;

import java.util.ArrayList;

public class ThreadedBTInorderTraversal {
    class Node{
        private int data;
        private int lTag;
        private int rTag;
        private Node left, right;
        public int getlTag() {
            return lTag;
        }
        public void setlTag(int lTag) {
            this.lTag = lTag;
        }
        public int getrTag() {
            return rTag;
        }
        public void setrTag(int rTag) {
            this.rTag = rTag;
        }
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

    public ArrayList<Integer> threadedIOT(Node dummy){
        ArrayList<Integer> res = new ArrayList<>();
        Node start = dummy;
        if(dummy.getlTag() == 0)
            return res;
        while (start.getlTag() != 0){
            start = start.getLeft();
        }

        while(start.getRight()!= dummy){
            if(start.getrTag()==0) {
                res.add(start.data);
                start = start.getRight();
            }
            else{
                res.add(start.data);
                start = start.getRight();
                while(start.getlTag()!=0){
                    start = start.getLeft();
                }
            }
        }
        res.add(start.data);

        return res;
    }

    public static void main(String[] args) {
        ThreadedBTInorderTraversal tbtit = new ThreadedBTInorderTraversal();
        ThreadedBTInorderTraversal.Node dummy = tbtit.new Node(Integer.MIN_VALUE);
        dummy.setlTag(1);
        dummy.setrTag(1);
        dummy.setRight(dummy);

        ThreadedBTInorderTraversal.Node one = tbtit.new Node(1);
        dummy.setLeft(one);
        one.setrTag(1);
        one.setlTag(1);

        ThreadedBTInorderTraversal.Node two = tbtit.new Node(2);
        one.setLeft(two);
        two.setrTag(1);
        two.setlTag(1);

        ThreadedBTInorderTraversal.Node three = tbtit.new Node(3);
        one.setRight(three);
        three.setrTag(1);
        three.setlTag(1);

        ThreadedBTInorderTraversal.Node four = tbtit.new Node(4);
        four.setrTag(0);
        four.setlTag(0);
        two.setLeft(four);
        four.setLeft(dummy);
        four.setRight(two);

        ThreadedBTInorderTraversal.Node five = tbtit.new Node(5);
        five.setrTag(0);
        five.setlTag(0);
        two.setRight(five);
        five.setLeft(two);
        five.setRight(one);

        ThreadedBTInorderTraversal.Node six = tbtit.new Node(6);
        six.setlTag(0);
        six.setlTag(0);
        three.setLeft(six);
        six.setLeft(one);
        six.setRight(three);

        ThreadedBTInorderTraversal.Node seven = tbtit.new Node(7);
        three.setRight(seven);
        seven.setlTag(0);
        seven.setrTag(0);
        seven.setLeft(three);
        seven.setRight(dummy);

        System.out.println(tbtit.threadedIOT(dummy).toString());
    }

}
