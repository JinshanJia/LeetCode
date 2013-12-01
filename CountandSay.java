
/*
 * Count and Say 
 *  The count-and-say sequence is the sequence of integers beginning as follows:
 *  1, 11, 21, 1211, 111221, ...
 *  1 is read off as "one 1" or 11.
 *  11 is read off as "two 1s" or 21.
 *  21 is read off as "one 2, then one 1" or 1211.
 *  Given an integer n, generate the nth sequence.
 *  Note: The sequence of integers will be represented as a string.
 */

public class CountandSay {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        StringBuilder sBuilder = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            char[] chars = sBuilder.toString().toCharArray();
            char tempChar = 0;
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (tempChar != 0) {
                    if (c == tempChar) {
                        count++;
                    } else {
                        sb.append(Integer.toString(count) + tempChar);
                        tempChar = c;
                        count = 1;
                    }
                } else {
                    tempChar = c;
                    count = 1;
                }
            }
            sb.append(Integer.toString(count) + tempChar);
            sBuilder = sb;
        }
        return sBuilder.toString();
    }
}
