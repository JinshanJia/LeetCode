/*
 * Single Number II 
 *  Given an array of integers, every element appears three times except for one. 
 *  Find that single one.
 *  
 *  Note:
 *      Your algorithm should have a linear runtime complexity. 
 *      Could you implement it without using extra memory?
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //TODO
        int oneTime = 0;
        int twoTimes = 0;
        int threeTimes = 0;
        for (int i = 0; i < A.length; i++) {
            twoTimes |= oneTime & A[i];
            oneTime ^= A[i];
            threeTimes = oneTime & twoTimes;
            oneTime &= ~threeTimes;
            twoTimes &= ~threeTimes;       
        }
        return oneTime;
    }
}
