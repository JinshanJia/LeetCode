/*
* Name: Jinshan Jia
* 10/22/2013
* Email: jiajinshan2009@gmail.com
* Problem: Reverse Integer 
*/
/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public static int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        int result = 0;
        while (x / 10 != 0) {
            int temp = x % 10;

            result = (result * 10) + temp;

            x /= 10;
        }
        return result * 10 + x;
    }
}
