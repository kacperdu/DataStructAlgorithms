package assignment2;

public class DivideAndConquer {

    public static int fibonacci(int n) {
        // TASK 1.A.a
        if (n == 0){
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2); // Recursive call in order to work with
                                                          // the fibonacci sequence
        }
    }

    public static int search(int[] A, int v)
    {
        // TASK 1.A.b
        int arrLength = A.length; // Amount of elements in array
        if (arrLength == 1){ // If array size = 1
            if (v == A[0]){ // If v matches the only element in array
                return 0; // Returns index at which the value is stored
            }
            else {
                return -1; // Otherwise returns -1 as instructed
            }
        }
        else {
            int mid = arrLength / 2; // Get middle index of array
            if (v == A[mid]){ // If v is the middle element
                return mid; // Returns middle index
            }
            else {
                if (v < A[mid]){ // If v is found in lower half of array
                    int[] leftArray = new int[mid]; // Hold lower half of array
                    // Using mid as size of array because array index starts at 0
                    // Ex. A[0,1,2,3,4,5,6,7,8,9]
                    // Mid = 10 / 2 = 5. A[5] = 5
                    // Lower half size = mid = 5
                    // Size wise   1   2   3   4   5
                    // Index wise [0],[1],[2],[3],[4]
                    // Elements   [0,  1,  2,  3,  4]

                    for (int i = 0; i < mid; i++){ // Start from first element, end before middle element
                        leftArray[i] = A[i];
                    }
                    return search(leftArray, v); // Recursively searching for v in lower half
                }
                else { // If it's not in lower half, it's in upper half
                    int[] rightArray = new int[arrLength - mid - 1]; // Hold top half of array
                    // Used arrLength - mid - 1 as size of array
                    // Ex. A[0,1,2,3,4,5,6,7,8,9]
                    // Upper half = [6, 7, 8, 9]
                    // Mid = 10 / 2 = 5. A[5] = 5
                    // arrLength = 10
                    // arrLength - mid = 10 - 5 = 5
                    // - 1 to exclude the mid
                    // arrLength - mid - 1 = 10 - 5 - 1 = 4
                    // Size wise    1   2   3   4
                    // Index wise  [0],[1],[2],[3]
                    // RightArray  [6,  7,  8,  9]

                    for (int i = mid + 1; i < arrLength; i++){  // Start from middle + 1 ,end at A length
                                                                // (Middle element already been decided as not being v)
                        rightArray[i - (mid + 1)] = A[i];
                        // Adjusting index for rightArray
                        // Ex. A[0,1,2,3,4,5,6,7,8,9]
                        // rightArray index                              0, 1, 2, 3 = [6, 7, 8, 9]
                        // A index of what we want to copy to rightArray 6, 7, 8, 9 = [6, 7, 8, 9]
                        // for loop ex. for(int i = (5 + 1 = 6); 6 < 10; 6++)
                        //                  rightArray[6 - (5 + 1)] = A[6]
                        //                  rightArray[6 - (6) = 0] = A[6]
                        //                  A[6] = 6
                        //         rightArray[0] = 6
                    }
                    int result = search(rightArray, v); // Recursively search for v in the right half of the array

                    if (result != -1){ // If v have been found, the index has to be adjusted
                        return result + mid + 1;
                        // Adjusting index for rightArray
                        // Note: rightArray starts it's index at
                        // Ex. rightArray[6, 7, 8, 9] v is 8, which is found in index 3 (rightArray[2] = 8).
                        // A[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] for array A, v which is 8, is found at index 8
                        // So
                        // result = 2 (index of v in rightArray)
                        // mid + 1 = 5 + 1 (Adding the indexes of the leftArray and + 1 for the middle)
                        // result + mid + 1 = 2 + 5 + 1 = 8 (Correct index of v in A)

                    }
                    else { // If not found
                        return -1; // Return -1 as instructed
                    }
                }
            }
        }
    }

    public static void hanoi(int n, char A, char B, char C)
    {
        // TASK 1.A.c
        if (n == 1){ // Of there is only one disk
            System.out.println(A + " Moves to " + C);
        }
        else { // If more than one
            hanoi(n-1, A, C, B);
            hanoi(1, A, B, C);
            hanoi(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            System.out.println(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i));
        }
        System.out.println();
        hanoi(4, 'A', 'B', 'C');
    }
}
