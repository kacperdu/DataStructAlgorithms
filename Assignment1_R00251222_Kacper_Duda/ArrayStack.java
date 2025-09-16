package assignment1;

public class ArrayStack implements Stack<Object> {
    private Object[] S;

    private int size; // Size of the array
    private int top; // Indexes most recently inserted element

    public ArrayStack(int capacity) {
        // TASK 2.A.a
        this.S = new Object[capacity]; // Create new Array with given capacity
        this.top = 0; // Since stack is empty, top is points to 0
        this.size = capacity; // Size is set to given capacity
    }

    public void push(Object x) {
        // TASK 2.A.b
        // Check if stack is full/ if there is an overflow
        if (this.top == this.size) {
            System.out.println("Overflow");
        }
        else {
            this.top++; // Increment top by one
            S[this.top] = x; // Insert new element at top
        }
    }

    public Object pop() {
        // TASK 2.A.c
        // Store current top
        Object x = S[this.top];
        // Check if stack is empty/ if there is an underflow
        if (this.top == 0){
            System.out.print("Underflow");
        }
        else {
            this.top--; // Decrement top by one
            x = S[this.top]; // Update x to store new top
        }
        return x;
    }

    public Object peek() {
        // TASK 2.A.d
        return S[this.top]; // Topmost element is the top
    }

    public boolean empty() {
        // TASK 2.A.e
        // Check if stack is empty
        // If no then returns false
        return this.top == 0; // If yes then returns true
    }

    public static void main(String[] args) {
        Stack<Object> test = new ArrayStack(20);
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
