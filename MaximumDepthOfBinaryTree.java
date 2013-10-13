/*
* Name: Jinshan Jia
* 10/13/2013
* Email: jiajinshan2009@gmail.com
* Problem: Maximum Depth of Binary Tree
*/
/*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the 
 * longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right) ? left + 1 : right + 1;
    }
}
