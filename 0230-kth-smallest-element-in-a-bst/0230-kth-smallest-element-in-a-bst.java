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

    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {

        /**
        이진 탐색 트리의 루트 노드와 정수 k가 주어졌을 때
        모든 노드의 값 중에서 k번째로 작은 값을 반환
         */
        
        // 중위 순회를 하면서 count를 통해 count가 k가 되었을 때 노드 값을 반환?
        inOrderSearch(root, k);

        return result;
    }

    // 중위 순회
    private void inOrderSearch(TreeNode node, int k) {
        if (node.left != null) inOrderSearch(node.left , k);
        count++;
        if (count == k) result = node.val;
        if (node.right != null) inOrderSearch(node.right, k);
    }

}