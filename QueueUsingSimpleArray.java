package generalPrograms;

public class QueueUsingSimpleArray {
    private int[] queueArray;
    int rear, size, front;
    private static final int capacity = 3;

    public QueueUsingSimpleArray(){
        this(capacity);
    }

    public QueueUsingSimpleArray(int size){
        queueArray = new int[size];
        rear = 0; size = 0; front = 0;
    }

    public void enQueue(int data) throws IllegalStateException{
        if(size == capacity){
            throw new IllegalStateException("Queue Overflow");
        }
        else{
            size++;
            queueArray[rear] = data;
            rear = (rear+1)%capacity;
        }
    }

    public int deQueue() throws IllegalStateException{
        if(size == 0)
            throw new IllegalStateException("Queue Underflow");
        else{
            size--;
            int data = queueArray[front];
            queueArray[front] = Integer.MIN_VALUE;
            front = (front+1)%capacity;
            return data;
        }
    }

    public boolean isFull(){
        return (size == capacity);
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void displayQueue(){
        String res = "[";
        for (int i=0;i<size;i++){
            int data = queueArray[(front+i)%capacity];
            res+=data;
            if(i<size-1)
                res+=",";;
        }
        res += "]";
        System.out.println(res);
    }


    public static void main(String[] args) {
        QueueUsingSimpleArray qusa = new QueueUsingSimpleArray();
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(11);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(12);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(13);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.deQueue();
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(14);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.deQueue();
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(15);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.deQueue();
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.enQueue(16);
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
        qusa.displayQueue();
        System.out.println("front value is: "+qusa.front + "rear value is: "+qusa.rear);
    }
}
