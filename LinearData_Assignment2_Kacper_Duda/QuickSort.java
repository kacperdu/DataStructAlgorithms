package assignment2;

public class QuickSort {

    private static int partition(int[] A, int p, int r)
    {
        // TASK 2.B.a
        int x = A[r]; // the pivot
        int i = p - 1; // highest index into the low side
        for (int j = p; j <= r - 1; j++){ // process each element other than the pivot
            if (A[j] <= x){ // Check if element belongs on low side or not
                // If yes
                i = i + 1; // index of a new slot in the low side
                // Temporary holders, otherwise would result in both having same value
                // Ex. Exchange A[i] = 5 and A[j] = 9
                // A[i] = A[j] (A[i] (5) is now A[j] (9))
                // A[j] = A[i] (A[j] (9) = A[i] (9))
                int tempj = A[j];
                int tempi = A[i];
                A[i] = tempj;
                A[j] = tempi;
            }
        }
        // Pivot goes just to the right of the low side, same logic applies with the temp
        int tempiplus1 = A[i +1];
        int tempPiv = A[r];
        A[i + 1] = tempPiv;
        A[r] = tempiplus1;

        return i + 1; // Returning index of pivot
    }

    private static void quicksort(int[] A, int p, int r)
    {
        // TASK 2.B.b
        if (p < r){ // Continues as long as there are elements in A, p = lowest element,
            // r = highest element, q to r make up entire array
            int q = partition(A,p,r); // Getting the pivot
            quicksort(A,p,q-1); // Recursively sort the low side
            quicksort(A,q + 1,r); // Recursively sort the high side
        }
    }

    public static void quicksort(int[] A)
    {
        quicksort(A, 0, A.length-1);
    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[] {5,2,8,1,3,9,7,4,6};
        quicksort(A);
        print(A);
    }

}
