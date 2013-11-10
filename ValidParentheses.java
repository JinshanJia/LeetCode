/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
import java.util.Stack;

/*
 * Valid Parentheses
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 *  determine if the input string is valid.
 *  
 *  The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 *  but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character tempChar = stack.pop();
                switch (c) {
                    case ')':
                        if (!tempChar.equals('(')) {
                            return false;
                        }
                        break;
                    case ']':
                        if (!tempChar.equals('[')) {
                            return false;
                        }
                        break;
                    case '}':
                        if (!tempChar.equals('{')) {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
