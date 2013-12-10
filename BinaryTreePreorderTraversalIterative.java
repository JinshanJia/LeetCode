import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Preorder Traversal 
 *  Given a binary tree, return the preorder traversal of its nodes' values.
 *  For example:
 *  Given binary tree {1,#,2,3},
 *  return [1,2,3].
 *  Note: Recursive solution is trivial, could you do it iteratively?
 */


public class BinaryTreePreorderTraversalIterative {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    root = null;
                } else {
                    root = stack.pop();
                }
            }  
        }
        return list;
    }
}
