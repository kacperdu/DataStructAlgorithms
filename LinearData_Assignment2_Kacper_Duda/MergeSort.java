package assignment2;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2)
    {
        // TASK 2.A.a
        int lengthA1 = A1.length; // Getting both of the sizes of these array
        int lengthA2 = A2.length;

        int[] mergedA = new int[lengthA1 + lengthA2]; // Using sizes from sub arrays for to be merged array

        int i = 0; // Value for getting  index of array A1
        int j = 0; // Value for getting index of array A2

        for (int k = 0; k < mergedA.length; k++){ // Iterate through mergedArray
            if (i < lengthA1 && j < lengthA2){ // Boundary check for both arrays
                if (A1[i] <= A2[j]){ // If A1's element at current index is smaller than A2's
                    mergedA[k] = A1[i]; // That element gets put into mergedA's k index position
                    i++; // Update of which index to be scanned/processed next in A1
                }
                else {
                    mergedA[k] = A2[j];
                    j++; // Update of which index to be scanned/processed next in A2
                }
            }
            // Above if loop doesn't take into consideration that one of the arrays may have an element left
            // While other is empty. If in a run, the A1 has 5 elements and A2 has 4,
            // After elements in A2 are exhausted, A1 has still one left
            // Loop ends as A1's i matches it's length
            // Fix this by implementing additional checks
            else if (i < lengthA1) {
                mergedA[k] = A1[i];
                i++; //
            }
            else {
                mergedA[k] = A2[j];
                j++;
            }
        }
        return mergedA;
    }

    public static int[] mergesort(int[] A)
    {
        // TASK 2.A.b
        if (A.length <= 1){ // If one element, return instantly
            return A;
        }
        else {
            int midInd = A.length / 2; // Middle index of array

            int[] A1 = new int[midInd]; // Half of array
            for (int i = 0; i < midInd; i++){ // Iterate and store before middle index
                A1[i] = A[i];
            }

            int[] A2 = new int[A.length - midInd]; // A1's half minus entire array size to get remaining half
            for (int i = midInd; i < A.length; i++){ // Iterate and store, starting from middle
                A2[i - midInd] = A[i]; // A2's index minus midInd value,
                // taking into account A2's indexes starting at 0 and A's indexes starting from midInd
            }

            int[] sortA1 = mergesort(A1); // Recursively sorting each half
            int[] sortA2 = mergesort(A2);

            return merge(sortA1, sortA2); // Merging into one array
            }
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
        print(merge(new int[] {1,3,5,7,9}, new int[] {2,4,6,8}));
        print(mergesort(new int[] {5,2,8,1,3,9,7,4,6} ));
        print(mergesort(new int[] {5,5,1,1,4,9,1} ));
    }

}
