/*
* Name: Jinshan Jia
* 10/09/2013
* Email: jiajinshan2009@gmail.com
* Problem: Remove Element
*/

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) {
            return 0;
        }
        int lastIndex = A.length - 1;
        int i;
        for (i = 0; i < A.length; i++) {
            if (i >= lastIndex) {
                break;
            }
            if (A[i] == elem) {
                for (; lastIndex > i; lastIndex--) {
                    if (A[lastIndex] != elem) {
                        A[i] = A[lastIndex];
                        lastIndex--;
                        break;
                    }
                }
            }
        }
        
        if (A[lastIndex] == elem) {
            return lastIndex;
        } else {
            return lastIndex + 1;
        }
    }
}
