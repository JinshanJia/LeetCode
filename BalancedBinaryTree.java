/*
* Name: Jinshan Jia
* 10/13/2013
* Email: jiajinshan2009@gmail.com
* Problem: Balanced Binary Tree
*/
/* 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = depth(root);
        if (result == -2) {
            return false;
        }
        return true;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        
        if (left == -2 || right == -2) {
            return -2;
        }
        if (left - right > 1 || left - right < -1) {
            return -2;
        }
        
        return (left > right) ? left + 1 : right + 1;
    }
}
