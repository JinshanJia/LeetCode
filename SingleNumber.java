/*
 * Single Number 
 *  Given an array of integers, 
 *  every element appears twice except for one. Find that single one.
 *  
 *  Note:
 *      Your algorithm should have a linear runtime complexity. 
 *      Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        for (int i = 1; i < A.length; i++) {
            A[0] = A[0] ^ A[i];
        }
        return A[0];
    }
}
