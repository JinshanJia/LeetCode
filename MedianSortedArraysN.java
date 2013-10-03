/*
* Name: Jinshan Jia
* 10/03/2013
* Email: jiajinshan2009@gmail.com
*/

public class MedianSortedArraysN {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
        int temp = 0;
        int a = 0;
        int b = 0;
        int previousItem = 0;
        int currentItem = 0;
        
        while (temp <= (m + n) / 2.0) {
            temp++;
            previousItem = currentItem;
            if (a >= A.length) {
                currentItem = B[b];
                b++;
            } else if (b >= B.length) {
                currentItem = A[a];
                a++;
            } else {
                if (A[a]> B[b]) {
                    currentItem = B[b];
                    b++;
                } else {
                    currentItem = A[a];
                    a++;
                }
            }
        }
        if ((m + n) % 2 != 0) {
            return currentItem;
        } else {
            return (previousItem + currentItem) / 2.0;
        }
    }
}
