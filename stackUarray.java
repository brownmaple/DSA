package generalPrograms;

public class stackUarray {
    private int max;
    private int top;
    private int[] sarray;

    public stackUarray(){
        max = 3;
        sarray = new int[max];
        top = -1;
      }

      private boolean isEmpty(){
        return (top<0);
      }

      private int pop(){

        if(top>-1){
            int elem = sarray[top--];
            System.out.println("element popped is "+ elem);
            return elem;
        }
        else {
            System.out.println("Underflow error");
            return 0;
        }
      }

      private void push(int elem){
        if(top+1<max){
            sarray[++top] = elem;
            System.out.println("element pushed "+ elem);
        }
        else
            System.out.println("Overflow error");
      }

      private int peek(){

          if(top > -1){
            int elem = sarray[top];
              System.out.println("peek-a-boo element is "+ elem);
              return elem;
          }
          else {
              System.out.println("Overflow error");
              return 0;
          }
      }

    public static void main(String[] args) {
        stackUarray sua = new stackUarray();
        sua.isEmpty();
        sua.push(10);
        sua.push(11);
        sua.push(12);
        sua.push(13);
        sua.peek();
        sua.pop();
    }
}
