/*
* Name: Jinshan Jia
* 10/09/2013
* Email: jiajinshan2009@gmail.com
* Problem:Length of Last Word 
*/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = 0;
        int preview = 0;
        for (int i = 0; i < s.length(); i++) {
            length++;
            if (s.charAt(i) == ' ') {
                if (length != 1) {
                    preview = length - 1;
                }
                length = 0;
            }
        }
        return length == 0 ? preview : length;
    }
}
