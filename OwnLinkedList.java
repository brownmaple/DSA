package generalPrograms;

public class OwnLinkedList<T> {
    Node head;
    Node tail;
    int length;

    public class Node<T>{
        T data;
        Node next;
        public Node(){

        }
        public Node(T data){
            this.data = data;
        }
        public T getData(){
            return this.data;
        }
        public void setData(T data){
            this.data = data;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public Node getNext(){
            return this.next;
        }
    }

    public void traverse(Node head){
        Node currnode = head;
        while(currnode.next !=null){
            System.out.println(currnode.data);
            currnode = currnode.next;
        }
        System.out.println(currnode.data);
    }

    public T deleteNode(Node head, int pos){
        Node currnode = head;
        int count = 1;
        while (count<pos-1){
            if(head.next!=null) {
                currnode = head.next;
                count++;
            }
            else{
                return null;
            }

        }
        currnode.next = currnode.next.next;

        return (T)currnode.data;
    }

    public void addNode(T data){
        Node currNode = head;
        if(currNode == null){
            Node<T> newNode = new Node<>(data);
            newNode.next = null;
            head = newNode;
            tail = newNode;
        }
        else{
            while(currNode.next!=null){
                currNode = currNode.next;
            }
            Node<T> newNode = new Node<>(data);
            currNode.next = newNode;
            newNode.next = null;
            tail = newNode;
            }
    }

    public void addNodeAt(T data, int pos){
        int count = 0;
        if(head == null){
            this.addNode(data);
        }
        else if(pos == 0){
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            this.head = newNode;
        }
        else {
            Node currNode = head;
            while (count < pos-1) {
                if (currNode.next != null) {
                    currNode = currNode.next;
                    count++;
                }
                else{
                    break;
                }
            }
            Node<T> newNode = new Node<>(data);
            if(currNode.next == null){
                currNode.next = newNode;
                newNode.next = null;
                tail = newNode;
            }
            else{
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
            }
        }
    }

    public static void main(String[] args) {
        OwnLinkedList oll = new OwnLinkedList();
        oll.addNode(5);
        oll.addNode(10);
        oll.addNode(15);
        oll.addNode(20);
        oll.addNode(25);
        oll.addNode(30);

        //oll.traverse(oll.head);

        oll.addNodeAt(50,7);
        oll.addNodeAt(7,1);
        oll.addNodeAt(3,0);
        oll.addNodeAt("one",0);
        oll.traverse(oll.head);

        System.out.println(oll.head.data);
        System.out.println(oll.tail.data);
        //oll.deleteNode(oll.head,3);
    }
}
