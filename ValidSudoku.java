/*
* Name: Jinshan Jia
* 11/12/2013
* Email: jiajinshan2009@gmail.com
*/
import java.util.ArrayList;
import java.util.HashSet;


/*
 * Valid Sudoku
 *  Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *  
 *  The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *  
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<HashSet<Character>> hashSets = new ArrayList<HashSet<Character>>();
        
        //hashSets 0 store the elements in the current row.
        //hashSets 1-9 store the elements in each column
        //hashSets 10-12 store the elements in three grids related the the current row;
        for (int i = 0; i < 13; i++) {
            hashSets.add(new HashSet<Character>());
        }
        
        for (int i = 0; i < board.length; i++) {
            hashSets.get(0).clear();
            for (int j = 0; j < board[i].length; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    hashSets.get(j / 3 + 10).clear();
                }
                if (board[i][j] != '.') {
                    if (hashSets.get(0).contains(board[i][j])) {
                        return false;
                    }
                    hashSets.get(0).add(board[i][j]);
                    if (hashSets.get(j + 1).contains(board[i][j])) {
                        return false;
                    }
                    hashSets.get(j + 1).add(board[i][j]);
                    if (hashSets.get(j / 3 + 10).contains(board[i][j])) {
                        return false;
                    }
                    hashSets.get(j / 3 + 10).add(board[i][j]);
                }
            }
        }
        
        return true;
    }
}
