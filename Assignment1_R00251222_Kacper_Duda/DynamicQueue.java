package assignment1;

public class DynamicQueue implements Queue<Object> {
    List<Object> Q = new DoubleLinkedList();

    public void enqueue(Object x) {
        // TASK 3.B.a
        // Elements added to queue get added at back of queue(tail) making this method appropriate
        Q.append(x); // Implementing append method from DoubleLinkedList
    }

    public Object dequeue() {
        // TASK 3.B.b
        Object x = Q.getFirst(); // Implementing getFirst method
        // Check if empty queue
        if (Q.empty()){
            System.out.print("Underflow");
        }
        else {
            // Removing elements happens at front of queue
            Q.deleteFirst();
        }
        return x;
    }

    public Object next() {
        // TASK 3.B.c
        return Q.getFirst(); // This method gets first element, which would be next in queue
    }

    public boolean empty() {
        // TASK 3.B.d
        return Q.empty();
    }

    public static void main(String[] args) {
        Queue<Object> test = new DynamicQueue();
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
