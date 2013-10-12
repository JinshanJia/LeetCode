/*
* Name: Jinshan Jia
* 10/12/2013
* Email: jiajinshan2009@gmail.com
* Problem:Same Tree 
*/


/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally 
identical and the nodes have the same value.
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
            }
        }
        return false;  
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }
}
