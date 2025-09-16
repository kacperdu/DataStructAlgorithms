package assignment1;

public class DoubleLinkedList implements List<Object> {
    private class ListNode {
        public ListNode(Object x) {
            key = x;
        }
        public Object key;
        public ListNode prev = null;
        public ListNode next = null;
    }
    // field
    private ListNode head; // Head of the list
    private ListNode tail; // Tail of the list
    private ListNode NIL; // Sentinel for list term

    public DoubleLinkedList()
    {
        // TASK 1.A
        // Creating NIL sentinel node with null key
        NIL = new ListNode(null);
        // Since list is supposed to be empty, both head and tail point to NIL
        this.head = NIL;
        this.tail = NIL;
    }

    public void prepend(Object x) {
        // TASK 1.B
        // First create node in which the object will be in
        ListNode newNode = new ListNode(x);
        // Check if list is empty
        if (this.head == NIL){
            // If so, newNode becomes head and tail, since it the only element(Node)
            this.head = newNode;
            this.tail = newNode;
            newNode.prev = NIL; // Ensure next and prev point to NIL
            newNode.next = NIL;
        }
        else{
            // If not, newNode gets inserted into list with already set head and tail
            newNode.next = this.head; // Insert newNode at beginning of list, behind current head
            newNode.prev = NIL; // Prev points to NIL
            this.head.prev = newNode; // Completing link between newNode and current head
            this.head = newNode; // newNode becomes new head
        }
    }

    public Object getFirst() {
        // TASK 1.C
        // Since in prepend method the first element became head, simply return head
        return this.head.key;
    }

    public void deleteFirst() {
        // TASK 1.D
        // Check if there is one element in list
        if (this.head == this.tail){
            // Setting both ensures erasure of the only element
            this.head = NIL;
            this.tail = NIL;
        }
        else {
            this.head = this.head.next; // Update head to old head's next
            this.head.prev = NIL; // New head's previous to NIL
        }
    }

    public void append(Object x) {
        // TASK 1.E
        ListNode newNode = new ListNode(x);
        // Check if list is empty
        if (this.tail == NIL){
            // If so, newNode becomes head and tail, since it the only element
            this.head = newNode;
            this.tail = newNode;
            newNode.next = NIL;
            newNode.prev = NIL;
        }
        else{
            // If not, newNode gets inserted into list with already set head and tail
            newNode.prev = this.tail; // NewNode gets placed ahead of current tail
            newNode.next = NIL;
            this.tail.next = newNode; // Completing link between newNode and current tail
            this.tail = newNode; // newNOde becomes new tail
        }
    }

    public Object getLast() {
        // TASK 1.F
        // Since in prepend method the first element became head, simply return head
        return this.tail.key;
    }

    public void deleteLast() {
        // TASK 1.G
        // Check if there is one element in list
        if (this.head == this.tail){
            // Setting both ensures erasure of the only element
            this.head = NIL;
            this.tail = NIL;
        }
        else {
            this.tail = this.tail.prev; // Tail updated to be the old head's prev
            this.tail.next = NIL; // This new tail points to NIL
        }

    }

    public boolean empty() {
        // TASK 1.H
        return this.tail == NIL && this.head == NIL;
    }

    public static void main(String[] args) {
        List<Object> test = new DoubleLinkedList();
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.prepend(i + 100);
        }
        System.out.println(test.empty());
        for (int i=0; i<5; i++) {
            int x = (int)test.getFirst();
            System.out.print(x + " ");
            test.deleteFirst();
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            test.append(i + 200);
        }
        while (!test.empty()) {
            int x = (int)test.getLast();
            System.out.print(x + " ");
            test.deleteLast();
        }
    }
}
