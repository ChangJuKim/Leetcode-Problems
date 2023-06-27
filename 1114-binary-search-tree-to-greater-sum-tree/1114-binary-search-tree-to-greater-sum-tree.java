/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) transformToGst(root, 0);
        return root;
    }

    public int transformToGst(TreeNode node, int currentSum) {
        if (node == null) return currentSum;
        currentSum = transformToGst(node.right, currentSum);
        currentSum += node.val;
        node.val = currentSum;
        currentSum = transformToGst(node.left, currentSum);
        return currentSum;
    }
}