package pers.liujicheng.leetcode.easy.mergetwobinarytrees;

/**
 * Created by JC on 2018/5/20.
 * <p>
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTree = null;
        if(null!=t1||null!=t2){
            newTree=new TreeNode(0);
            marge(t1, newTree);
            marge(t2, newTree);
        }
        return newTree;
    }

    public void marge(TreeNode t, TreeNode newTree) {
        if (null == t) {
            return;
        }
        newTree.val += t.val;
        if (null != t.left) {
            if (null==newTree.left){
                newTree.left=new TreeNode(0);
            }
            marge(t.left,newTree.left);
        }
        if (null != t.right) {
            if (null==newTree.right){
                newTree.right=new TreeNode(0);
            }
            marge(t.right,newTree.right);
        }
    }

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}


