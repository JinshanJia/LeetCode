/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
/*
 * Palindrome Number 
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = 1;
        if (x < 0) {
            return false;
        }
        int tempX = x;
        while (tempX / 10 != 0) {
            n++;
            tempX /= 10;
        }
        for (int i = 0; i < n / 2; i++) {
            if ((x / (int)Math.pow(10, (n - i - 1)) % 10) != (x / (int)Math.pow(10, i)) % 10) {
                return false;
            }
        }
        return true;
    }
}
