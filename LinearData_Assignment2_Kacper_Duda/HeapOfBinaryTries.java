package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    private void heapify(int i)
    {
        // TASK 3.A.a
        int smallest = i;
        int l = (2 * i) + 1; // Left side (Index)
        // Ex. i = root
        // Index  0 1 2  3  4  5  6
        // Array [5 7 10 12 15 17 20]
        // Left is 7
        // So it's index should be 1
        // 2*i(0) + 1 = 1
        int r = (2 * i) + 2; // Right side (Index)
        // Ex. i = root
        // Index  0 1 2  3  4  5  6
        // Array [5 7 10 12 15 17 20]
        // Right is 10
        // So it's index should be 2
        // 2*i(0) + 2 = 2

        if (l < heapsize && A[l].compare(A[smallest])){ // If left child is smaller than root
            smallest = l;
        }
        if (r < heapsize && A[r].compare(A[smallest])){ // If right is smaller than current smallest
            smallest = r;
        }
        if (smallest != i){ // If smallest isn't currently i, swap
            // Using temp variables, Without them re-arranging this would be all wrong
            // Ex.   i = 10
            // smallest = 5
            // Without temp:
            // smallest = i (smallest is now 10)
            // i = smallest (i is just assigned the same value)
            BinaryTrie tempsmall = A[smallest];
            BinaryTrie tempi = A[i];
            A[i] = tempsmall;
            A[smallest] = tempi;
            heapify(smallest); // Recursively sort heap from the smallest root to larger descendants
        }

    }

    public HeapOfBinaryTries(BinaryTrie[] A)
    {
        // TASK 3.A.b
        this.A = A; // Given A becomes the new A
        this.heapsize = A.length; // Update heapsize to given A's size
        for (int i = (heapsize/2) - 1; i >= 0; i--){ // Iterate in reverse order
            // Start at heapsize/2 - 1, starting from index of last non-leaf index
            // Non-leaf nodes are nodes that have at least one child, leaf nodes are at end and have no children
            // Leaf nodes do not need to be heapified, for the reason that they have no children to be compared to.
            // While Non-leaf nodes do have at least one child, and heapify ensures the node's child(ren) are larger
            heapify(i); // Recursively calling heapify for each node to have descending order
        }
    }

    public BinaryTrie extractMin()
    {
        // TASK 3.A.c
        if (heapsize < 1){
            System.out.println("heap underflow, cannot extract");
            return null; // No elements, nothing to return
        }
        else {
            BinaryTrie min = A[0]; // Since the heap's root is smaller than all of its descendants,
                                   // Simply return the root
            A[0] = A[heapsize - 1]; // Last element to root, by doing this, we ensure all elements are in descending
                                    // Order after heapify is done
                                    // (Ensure fields are initialised correctly)
            heapsize = heapsize - 1; // Decrease the size of the heap, since this is an extraction
            heapify(0); // Sorting the heap
            return min;
        }
    }

    public void insert(BinaryTrie x) {
        // TASK 3.A.d
        if (heapsize == A.length){ // If heap is full, overflow will occur if you try to insert
            System.out.println("Heap overflow");
        }
        else{
            heapsize = heapsize + 1; // Increase heap size
            int newIndexA = heapsize - 1; // Index for new element, -1 because index starts at 0 while heapsize (count of elements) starts at 1
            A[newIndexA] = x; // Insert element into given index
            while (newIndexA > 0 && A[(newIndexA - 1) / 2].compare(A[newIndexA])){
                // newIndex > 0, ensure it's not root, root has no parent
                // (newIndexA-1)/2 = parent of current node
                // Compares new node with parent
                // Using same logic as before for replacing values
                BinaryTrie tempIndex = A[newIndexA];
                BinaryTrie tempParent = A[(newIndexA - 1) / 2];
                A[newIndexA] = tempParent;
                A[(newIndexA - 1) / 2] = tempIndex;

                newIndexA = (newIndexA - 1) / 2; // new node now at parent's position, updating index value
            }


        }

    }

    public int size()
    {
        return heapsize;
    }
}
