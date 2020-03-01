package generalPrograms;

import java.util.Stack;

public class ReverseStackRecursion {
    Stack<Integer> sRef;


    public void reverseStack(Stack<Integer> stck){
        Integer top = stck.pop();

        if(!stck.isEmpty())
            reverseStack(stck);
        bottomInsert(top);
    }

    public void bottomInsert(Integer bot){

        if(sRef.isEmpty()){
            sRef.push(bot);
        }
        else{
           Integer bottom = sRef.pop();
            bottomInsert(bot);
            sRef.push(bottom);
        }

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        ReverseStackRecursion rsr = new ReverseStackRecursion();
        rsr.sRef=s;
        rsr.reverseStack(s);
        System.out.println(s);
        Object n;
    }
}
