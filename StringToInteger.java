/*
* Name: Jinshan Jia
* 10/22/2013
* Email: jiajinshan2009@gmail.com
* Problem: String to Integer (atoi)
*/

/*
 * Implement atoi to convert a string to an integer.
 */
public class StringToInteger {
    public static int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.

        String string = str.trim();
        if (string.equals("")) {
            return 0;
        }


        long result = 0;
        if (string.charAt(0) == '-') {
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) > '9' || string.charAt(i) < '0') {
                    break;
                }

                result = result * 10 + (int) (string.charAt(i) - '0');
                if (result > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }
            result *= -1;
        } else if (string.charAt(0) == '+') {
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) > '9' || string.charAt(i) < '0') {
                    break;
                }

                result = result * 10 + (int) (string.charAt(i) - '0');
                if (result >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

            }
        } else {
            for (char c : string.toCharArray()) {
                if (c > '9' || c < '0') {
                    break;
                }
                result = result * 10 + (int) (c - '0');
                if (result >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }

        return (int)result;
    }
}
