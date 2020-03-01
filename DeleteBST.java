package generalPrograms;

public class DeleteBST {

    class Node{
        private int data;
        private Node left, right;
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

    public Boolean deleteNode(Node root,Node inp){
        if(inp.getLeft()==null && inp.getRight()==null) { //LeafNode - case1
            Node parent = findParentNode(root, inp);
            if(parent.getRight()==inp)
                parent.setRight(null);
            else parent.setLeft(null);
        }

        else if(inp.getRight()!=null && inp.getLeft()!=null){ //Node with two child - case3
            Node leftChild = inp.getLeft();
            Node leftChildRight = leftChild.getRight();
            if(leftChildRight!=null) {
                while (leftChildRight.getRight() != null) {
                    leftChildRight = leftChildRight.getRight();
                }

                inp.data = leftChildRight.data;
                if(leftChildRight.getLeft()!=null){
                    leftChildRight.data = leftChildRight.getLeft().data;
                    leftChildRight.setLeft(null);
                }
                else leftChild.setRight(null);
            }
            else{
                leftChild.setRight(inp.getRight());
                inp.setRight(null);
                inp.setLeft(null);
            }
        }

        else if(inp.getRight()!=null || inp.getLeft()!=null){ //Node with one child - case2
//            Node parent = findParentNode(root, inp);
//            Node child = inp.getLeft() != null ? inp.getLeft():inp.getRight();
//            if(parent.getLeft()==inp)
//                parent.setLeft(child);
//            else parent.setRight(child);
            Node child = inp.getLeft() != null ? inp.getLeft():inp.getRight();
            inp.data = child.data;
            inp.setLeft(null);
            inp.setRight(null);
        }
        return true;
    }

    public Node findNode(Node root, int data){
        System.out.println("in stack: "+root.data);
        if(root == null)
            return null;
        if(data < root.data)
            root = findNode(root.getLeft(),data);
        if(data > root.data)
            root = findNode(root.getRight(),data);

        return root;
    }

    public Node findParentNode(Node root, Node inp){
        if(root==inp)
            return root;
        while(root!=null){
            if(inp.data<root.data && root.getLeft()!= inp)
                root = root.getLeft();
            else if(inp.data>root.data && root.getRight()!= inp)
                root = root.getRight();
            else return root;
        }
      return null; //unreachable
    }

    public void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.data+" ");
        inOrder(root.getRight());
    }

    public static void main(String[] args) {
        DeleteBST dbst = new DeleteBST();
        Node ten = dbst.new Node(10);
        Node eight = dbst.new Node(8);
        Node eleven = dbst.new Node(11);
        Node seven = dbst.new Node(7);
        Node nine = dbst.new Node(9);
        Node fourteeen = dbst.new Node(14);
        Node twelve = dbst.new Node(12);
        Node five = dbst.new Node(5);
        Node thirteen = dbst.new Node(13);
        ten.setLeft(eight);
        ten.setRight(twelve);
        eight.setLeft(seven);
        eight.setRight(nine);
        seven.setLeft(five);
        twelve.setRight(thirteen);
        twelve.setLeft(eleven);
        thirteen.setRight(fourteeen);

        //Node res = dbst.findNode(ten,5);
        //System.out.println(res.data);
        //Node par = dbst.findParentNode(ten,twelve);
        //System.out.println(par.data);
        //dbst.inOrder(ten);
        dbst.deleteNode(ten,ten);
        dbst.inOrder(ten);
    }
}
