/*
* Name: Jinshan Jia
* 10/12/2013
* Email: jiajinshan2009@gmail.com
* Problem:Symmetric Tree 
*/

/*
 * Given a binary tree, 
 * check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (root == null) {
            return true;
        }
        TreeNode rightNode = root.right;
        TreeNode lefNode = root.left;
        return compareLeftAndRight(lefNode, rightNode);

    }

    private boolean compareLeftAndRight(TreeNode leftTreeNode,
            TreeNode rightTreeNode) {
        if (leftTreeNode == null || rightTreeNode == null) {
            return (leftTreeNode == null && rightTreeNode == null);
        }

        if (leftTreeNode.val != rightTreeNode.val) {
            return false;
        }

        return (compareLeftAndRight(leftTreeNode.left, rightTreeNode.right) && compareLeftAndRight(
                rightTreeNode.left, leftTreeNode.right));
    }

    /*
     * iterator way
     */

    public boolean isSymmetricIterate(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (root == null) {
            return true;
        }

        MyTreeStack leftStack = new MyTreeStack();
        leftStack.push(root.left);

        MyTreeStack rigthStack = new MyTreeStack();
        rigthStack.push(root.right);

        TreeNode templeftNode = null;
        TreeNode temprightNode = null;
        while (!leftStack.isEmpty() && !rigthStack.isEmpty()) {
            templeftNode = leftStack.pop();
            temprightNode = rigthStack.pop();
            if (templeftNode == null && temprightNode == null) {
                continue;
            }

            if (templeftNode == null || temprightNode == null) {
                return false;
            }

            if (templeftNode.val != temprightNode.val) {
                return false;
            }
            leftStack.push(templeftNode.left);
            leftStack.push(templeftNode.right);

            rigthStack.push(temprightNode.right);
            rigthStack.push(temprightNode.left);

        }
        return (leftStack.isEmpty() && rigthStack.isEmpty());

    }

    private class MyTreeStack {
        int size = 0;
        StackItem top = null;

        public void push(TreeNode node) {
            StackItem item = new StackItem(node, top);
            size++;
            top = item;
        }

        public TreeNode pop() {
            if (size == 0) {
                return null;
            }
            size--;
            StackItem tempItem = top;
            top = top.nextItem;
            return tempItem.node;
        }

        public boolean isEmpty() {
            return (size == 0);
        }
    }

    private class StackItem {
        TreeNode node = null;
        StackItem nextItem = null;

        public StackItem(TreeNode node, StackItem nextItem) {
            this.node = node;
            this.nextItem = nextItem;
        }
    }
}
