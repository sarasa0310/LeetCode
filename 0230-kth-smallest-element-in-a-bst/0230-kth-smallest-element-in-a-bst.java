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
    public int kthSmallest(TreeNode root, int k) {

        /**
        이진 탐색 트리의 루트 노드와 정수 k가 주어졌을 때
        모든 노드의 값 중에서 k번째로 작은 값을 반환
         */

        // 중위 순회 -> 정렬된 값 중에서 k - 1번째 인덱스 값 반환

        // 1. 모든 노드의 값을 담아줄 values
        List<Integer> values = new ArrayList<>();

        // 2. 중위 순회를 통해 values에 값을 정렬하여 채우기
        inOrderSearch(root, values);

        // 3. values의 k - 1번째 인덱스 값 리턴
        return values.get(k - 1);
    }

    // 중위 순회
    private void inOrderSearch(TreeNode node, List<Integer> values) {
        if (node.left != null) inOrderSearch(node.left, values);
        values.add(node.val);
        if (node.right != null) inOrderSearch(node.right, values);
    }

}