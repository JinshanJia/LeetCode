/*
* Name: Jinshan Jia
* 10/09/2013
* Email: jiajinshan2009@gmail.com
* Problem: Plus One
*/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                break;
            }
        }
        if (i == -1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
