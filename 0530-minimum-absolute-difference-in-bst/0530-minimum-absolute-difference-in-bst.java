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
    private int minDif = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDif;
    }

    // 중위 순회
    private void inOrder(TreeNode node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            if (prev != null) {
                minDif = Math.min(minDif, node.val - prev.val);
            }
            prev = node;
            if (node.right != null) inOrder(node.right);
        }
    }

}