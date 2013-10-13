/*
* Name: Jinshan Jia
* 10/13/2013
* Email: jiajinshan2009@gmail.com
* Problem: Path Sum
*/
/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return (root.val == sum);
        }
        return (hasPathSum(root.left, sum - root.val) || 
                    hasPathSum(root.right, sum - root.val));
        
    }
}
