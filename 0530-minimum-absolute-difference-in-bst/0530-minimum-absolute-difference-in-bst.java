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
    public int getMinimumDifference(TreeNode root) {

        /**
        - 이진 탐색 트리의 루트 노드가 주어졌을 때
        - 노드 간 최소 절대 차이값을 반환
         */

        // 1. 중위 순회를 통해 values에 모든 값 집어 넣기
        List<Integer> values = new ArrayList<>();

        inOrder(root, values); // 중위 순회이므로 정렬되어 있음

        // 2. 최소 차이값 찾기
        int result = Integer.MAX_VALUE; // 정수 최대값으로 초기화

        // 정렬되어 있으므로 1차원 반복문으로 해결 가능
        for (int i = 0; i < values.size() - 1; i++) {
            int dif = values.get(i + 1) - values.get(i);
            if (dif < result) result = dif;
        }

        return result;
    }

    // 중위 순회
    private void inOrder(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) inOrder(node.left, values);
            values.add(node.val);
            if (node.right != null) inOrder(node.right, values);
        }
    }

}