package assignment1;

public class ArrayQueue implements Queue<Object> {
    private Object[] Q;

    private int head; // Points to position at front of queue where elements are removed
    private int tail; // Points to position back of queue where new elements are going to be added
    private int size; // Capacity of the queue

    public ArrayQueue(int capacity) {
        // TASK 3.A.a
        this.Q = new Object[capacity]; // Create array with capacity size
        this.head = 0; // Head at position 0
        this.tail = 0; // Tail at position 0
        this.size = capacity; // Queue size
    }

    public void enqueue(Object x) {
        // TASK 3.A.b
        // Check if queue is full, number of elements vs max allowed elements
        if (this.size == Q.length){
            // If yes then inserting another element would result in an overflow
            System.out.print("Overflow");
        }
        else{
            Q[this.tail] = x; // x inserted at tail position
            // Check if this position is last in queue
            if (this.tail == this.size){
                // If tail is pointing to 1st position in queue
                this.tail = 1; // tail points to first position of queue
            }
            else{
                this.tail = this.tail + 1; // tail now points to next position
            }


        }
    }

    public Object dequeue() {
        // TASK 3.A.c
        Object x = Q[this.head]; // Store head element
        // Check if queue is empty
        if (this.head == this.tail){
            // If yes then removing an element would result in underflow
            System.out.print("Underflow");
        }
        else{
            // Check if this position is last in queue
            if (this.head == this.size){
                this.head = 1; // head gets placed at one
            }
            else {
                this.head = this.head + 1;// head position gets increased by one
            }
            }
        return x;
    }

    public Object next() {
        // TASK 3.A.d
        return Q[head]; // Returns next element in queue, next in queue would be first in queue
    }

    public boolean empty() {
        // TASK 3.A.e
        return this.head == this.tail; // When head == tail the queue is empty
    }

    public static void main(String[] args) {
        Queue<Object> test = new ArrayQueue(20);
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.enqueue(i+100);
        }
        System.out.println(test.empty());
        System.out.println(test.next());
        for (int i=0; i<5; i++) {
            int x = (int)test.dequeue();
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i=0; i<15; i++) {
            test.enqueue(i);
        }
        while (!test.empty()) {
            int x = (int)test.dequeue();
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
