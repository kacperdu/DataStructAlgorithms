package assignment1;

public class DynamicStack implements Stack<Object> {
    List<Object> S = new DoubleLinkedList();

    public void push(Object x) {
        // TASK 2.B.a
        // Since stack inserts elements at top, this method would be appropriate
        S.append(x); // Implementing method from DoubleLinkedList to add elements
    }

    public Object pop() {
        // TASK 2.B.b
        // Check if the stack is empty
        Object x = S.getLast(); // Save top most element
        if (S.empty()){ // Check if stack is empty
            System.out.print("Underflow");
        }
        else {
            S.deleteLast(); // Delete top most element
        }
        return x;
    }

    public Object peek() {
        // TASK 2.B.c
        return S.getLast(); //This method gets last element, which would be top of a stack

    }

    public boolean empty() {
        // TASK 2.B.d
        return S.empty(); // Check if empty
    }

    public static void main(String[] args) {
        Stack<Object> test = new DynamicStack();
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.push(i+100);
        }
        System.out.println(test.empty());
        System.out.println(test.peek());
        for (int i=0; i<5; i++) {
            int x = (int)test.pop();
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i=0; i<15; i++) {
            test.push(i);
        }
        while (!test.empty()) {
            int x = (int)test.pop();
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
