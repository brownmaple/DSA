package generalPrograms;

public class PostOrderSuccessorInITBT {

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

    public void threadedPOT(Node input){
        Node start = input;
        while(1==1){
          start =  postOrderSuccessor(start);
          if(start==input)
              return;
            System.out.print(start.data);
        }
//        System.out.print(input.data);
    }

    public Node postOrderSuccessor(Node input){
        Node p = input;
        if(p.getrTag()==0) {
            p = p.getRight();
            if (p.getLeft() != input) {
                p = p.getLeft();
                while (p.getRight() != input) {
                    p = p.getRight();
                }
                return p;
            } else {
                return p.getRight();
            }
        }
        else{
//            if(p.getRight()==p){
//                return p.getLeft();
//            }

            while(p.getrTag()==1){
                p=p.getRight();
            }
            p=p.getRight();
            if(p.getLeft()==input) {
                if (p.getrTag() != 0) {
                    p = p.getRight();
                    while (p.getlTag() != 0) {
                        p = p.getLeft();
                    }
                    return p;
                } else {
                    return p;
                }
            }
            // newly addded
            else if(p.getRight()==p){
                p = p.getLeft();
                while(p.getRight()!=input){
                    p=p.getRight();
                }
                return p;
            }


            else {
                while (p.getlTag() == 1) {
                    p = p.getLeft();
                }
                return p.getLeft();
            }
            }
    }

    public static void main(String[] args) {
        PostOrderSuccessorInITBT postbt = new PostOrderSuccessorInITBT();
        Node dummy = postbt.new Node(Integer.MIN_VALUE);
        dummy.setlTag(1);
        dummy.setrTag(1);
        dummy.setRight(dummy);

        Node one = postbt.new Node(1);
        dummy.setLeft(one);
        one.setrTag(1);
        one.setlTag(1);

        Node two = postbt.new Node(2);
        one.setLeft(two);
        two.setrTag(1);
        two.setlTag(1);

        Node three = postbt.new Node(3);
        one.setRight(three);
        three.setrTag(1);
        three.setlTag(1);

        Node four = postbt.new Node(4);
        four.setrTag(0);
        four.setlTag(0);
        two.setLeft(four);
        four.setLeft(dummy);
        four.setRight(two);

        Node five = postbt.new Node(5);
        five.setrTag(0);
        five.setlTag(0);
        two.setRight(five);
        five.setLeft(two);
        five.setRight(one);

        Node six = postbt.new Node(6);
        six.setlTag(0);
        six.setlTag(0);
        three.setLeft(six);
        six.setLeft(one);
        six.setRight(three);

        Node seven = postbt.new Node(7);
        three.setRight(seven);
        seven.setlTag(0);
        seven.setrTag(0);
        seven.setLeft(three);
        seven.setRight(dummy);

        //System.out.println(postbt.postOrderSuccessor(seven).data);
        postbt.threadedPOT(three);
    }
}
