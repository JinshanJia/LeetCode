import java.util.ArrayList;

/*
 * Binary Tree Postorder Traversal 
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 *  For example:
 *      Given binary tree {1,#,2,3},
 *      return [3,2,1].
 *      
 *  Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversalRecursive {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
