/*
* Name: Jinshan Jia
* 11/09/2013
* Email: jiajinshan2009@gmail.com
* Problem:Word Ladder 
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Word Ladder
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, 
 * such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */
public class WordLadder {    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (start.equals(end)) {
            return 0;
        }
        dict.add(end);
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        int steps = 1;
        int nextLevelNumber = 0;
        int currentLevelNumber = 1;
        dict.remove(start);
        while (!queue.isEmpty()) {
            String currentString = queue.remove();
            currentLevelNumber--;
            if (currentString.equals(end)) {
                return steps;
            }
            int length = currentString.length();
            for (int i = 0; i < length; i++) {
                StringBuilder tempSBuilder = new StringBuilder(currentString);
                for (int j = 0; j < 26; j++) {
                    tempSBuilder.setCharAt(i, (char) (j + 'a'));
                    if (dict.contains(tempSBuilder.toString())) {
                        queue.add(tempSBuilder.toString());
                        dict.remove(tempSBuilder.toString());
                        nextLevelNumber++;
                    }
                }
            }
            if (currentLevelNumber == 0) {
                steps++;
                currentLevelNumber = nextLevelNumber;
                nextLevelNumber = 0;
            }
        }
        return 0;
    }
}
