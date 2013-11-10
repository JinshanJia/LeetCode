/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
import java.util.HashSet;
/*
 * Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashSet<Character> hashSet = new HashSet<Character>();
        hashSet.add('I'); // 1
        hashSet.add('V'); // 5
        hashSet.add('X'); // 10
        hashSet.add('L'); // 50
        hashSet.add('C'); // 100
        hashSet.add('D'); // 500
        hashSet.add('M'); // 1000
        int result = 0;
        char[] characters = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            Character character = characters[i];
            if (!hashSet.contains(character)) {
                return 0;
            }
            switch (character) {
            case 'I':
                if (i != s.length() - 1
                        && (characters[i + 1] == 'V' || characters[i + 1] == 'X')) {
                    result -= 1;
                } else {
                    result += 1;
                }
                break;
            case 'V':
                result += 5;
                break;
            case 'X':
                if (i != s.length() - 1
                        && (characters[i + 1] == 'L' || characters[i + 1] == 'C')) {
                    result -= 10;
                } else {
                    result += 10;
                }
                break;
            case 'L':
                result += 50;
                break;
            case 'C':
                if (i != s.length() - 1
                        && (characters[i + 1] == 'D' || characters[i + 1] == 'M')) {
                    result -= 100;
                } else {
                    result += 100;
                }
                break;

            case 'D':
                result += 500;
                break;
            case 'M':
                result += 1000;
                break;
            default:
                break;
            }
        }
        return result;
    }
}
