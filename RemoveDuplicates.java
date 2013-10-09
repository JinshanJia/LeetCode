/*
* Name: Jinshan Jia
* 10/09/2013
* Email: jiajinshan2009@gmail.com
* Problem: Remove Duplicates from Sorted Array
*/

public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) {
            return 0;
        }
        int moveToIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[moveToIndex]) {
                moveToIndex++;
                A[moveToIndex] = A[i];
            }
        }
        return moveToIndex + 1;
    }
}
