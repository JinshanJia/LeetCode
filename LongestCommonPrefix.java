/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
import java.util.Collections;
import java.util.LinkedList;

/*
 * Longest Common Prefix
 * 
 * Write a function to find the longest common 
 * prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (strs.length == 0) {
            return "";
        }
        LinkedList<String> list = new LinkedList<String>();
        for (String string : strs) {
            list.add(string);
        }
        Collections.sort(list);
        String first = list.getFirst();
        String last = list.getLast();
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                commonPrefix.append(first.charAt(i));
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
}
