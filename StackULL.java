package generalPrograms;

import java.util.Iterator;
import java.util.LinkedList;

public class StackULL implements Cloneable{
    LinkedList<Integer> forStack;

    public StackULL(LinkedList<Integer> llb){
        this.forStack = llb;
    }
    public void push(Integer elem){
        this.forStack.addFirst(elem);
    }

    public Integer pop(){
        Integer poppedElem = this.forStack.getFirst();
        this.forStack.removeFirst();
        return poppedElem;
    }

    public Integer peek(){
       return this.forStack.getFirst();
    }

    public void display(){
        Iterator itr = this.forStack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        StackULL sull = new StackULL(stack);
        sull.push(5);
        sull.push(6);
        sull.push(7);
        sull.push(8);
        sull.push(9);
        sull.push(10);
        try {
          Object x=  sull.clone();
        }
        catch(CloneNotSupportedException c){

        }
        sull.display();
        Integer peekedElem = sull.peek();
        System.out.println("Peeked Element is: "+peekedElem);
        Integer poppedElem = sull.pop();
        System.out.println("Popped Element is: "+poppedElem);
        sull.display();
    }
}
