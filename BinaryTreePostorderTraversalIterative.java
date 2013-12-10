import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Postorder Traversal 
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 *  For example:
 *      Given binary tree {1,#,2,3},
 *      return [3,2,1].
 *      
 *  Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversalIterative {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode lastNode = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastNode) {
                    root = peekNode.right;
                } else {
                    stack.pop();
                    lastNode = peekNode;
                    list.add(lastNode.val);
                }
            }
        }
        return list;
    }
}
