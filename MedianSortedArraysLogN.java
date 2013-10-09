/*
* Name: Jinshan Jia
* 10/08/2013
* Email: jiajinshan2009@gmail.com
*/
public class MedianSortedArraysLogN {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ((A.length + B.length) % 2 == 0) {
            return (findKthNumber(A, A.length, 0, B, B.length, 0, (A.length + B.length) / 2) 
                    + findKthNumber(A, A.length, 0, B, B.length, 0, (A.length + B.length) / 2 + 1))
                    / 2.0;
        } else {
            return findKthNumber(A, A.length, 0, B, B.length, 0, (A.length + B.length) 
                    / 2 + 1);
        }
    }
    
    public int findKthNumber(int[]A, int m, int startA, int[] B, int n, int startB, int k) {
        if (m > n) {
            return findKthNumber(B, n, startB, A, m, startA, k);
        }
        if (m == 0) {
            return B[k - 1 + startB];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int pm = Math.min(m, k/2);
        int pn = k - pm;
        if (A[pm - 1 + startA] < B[pn - 1 + startB]) {
            return findKthNumber(A, m - pm, pm + startA, B, n, startB, k - pm);
        } else if (A[pm - 1 + startA] > B[pn - 1 + startB]) {
            return findKthNumber(A, m, startA, B, n - pn, pn + startB, k - pn);
        } else {
            return A[pm -1 + startA];
        }
    }
}
