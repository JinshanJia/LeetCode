/*
* Name: Jinshan Jia
* 11/12/2013
* Email: jiajinshan2009@gmail.com
*/
/*
 * Search Insert Position
 *  Given a sorted array and a target value, return the index if the target is found. 
 *  If not, return the index where it would be if it were inserted in order.
 *  
 *  You may assume no duplicates in the array.
 *  
 *  Here are few examples.
 *      [1,3,5,6], 5 -> 2
 *      [1,3,5,6], 2 -> 1
 *      [1,3,5,6], 7 -> 4
 *      [1,3,5,6], 0 -> 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return binarySearch(A, 0, A.length - 1, target);
    }
    
    public int binarySearch(int[] A, int start, int end, int target) {
        if (start >= end) {
            if (A[start] >= target) {
                return start;
            } else {
                return start + 1;
            }
        } else {
            if (A[(start + end) / 2] == target) {
                return (start + end) / 2;
            } else if (A[(start + end) / 2] < target) {
                return binarySearch(A, (start + end) / 2 + 1, end, target);
            } else {
                return binarySearch(A, start, (start + end) / 2 - 1, target);
            }
        }
    }
}
