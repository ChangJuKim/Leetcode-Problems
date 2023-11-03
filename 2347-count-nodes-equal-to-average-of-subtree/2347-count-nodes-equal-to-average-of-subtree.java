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

    private class SubtreeDetails {
        public int numNodes;
        public int totalSum;
        public int numNodesWithAverage;

        public SubtreeDetails(int numNodes, int totalSum, int numNodesWithAverage) {
            this.numNodes = numNodes;
            this.totalSum = totalSum;
            this.numNodesWithAverage = numNodesWithAverage;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        SubtreeDetails details = getSubtreeDetails(root);
        return details.numNodesWithAverage;
    }

    public SubtreeDetails getSubtreeDetails(TreeNode root) {
        if (root == null) {
            return new SubtreeDetails(0, 0, 0);
        }

        SubtreeDetails leftDetails = getSubtreeDetails(root.left);
        SubtreeDetails rightDetails = getSubtreeDetails(root.right);

        int numNodes = 1 + leftDetails.numNodes + rightDetails.numNodes;
        int totalSum = root.val + leftDetails.totalSum + rightDetails.totalSum;
        int numNodesWithAverage = (totalSum / numNodes == root.val) ? 1 : 0;
        numNodesWithAverage += leftDetails.numNodesWithAverage + rightDetails.numNodesWithAverage;

        return new SubtreeDetails(numNodes, totalSum, numNodesWithAverage);
    }
}