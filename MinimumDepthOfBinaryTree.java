/*
* Name: Jinshan Jia
* 10/13/2013
* Email: jiajinshan2009@gmail.com
* Problem: Minimum Depth of Binary Tree 
*/
/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along 
 * the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (root == null) {
            return 0;
        }
        
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } 
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left < right) ? left + 1 : right + 1;
    }
}
