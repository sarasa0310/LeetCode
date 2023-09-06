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

        inOrder(root, values);

        System.out.println(values);

        // 2. 이중 반복문으로 최소 절대 차이값 찾기
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < values.size() - 1; i++) {
            int dif = values.get(i + 1) - values.get(i);
            if (dif < result) result = dif;
        }

        // for (int i = 0; i < values.size(); i++) {
        //     for (int j = i + 1; j < values.size(); j++) {
        //         int difAbs = Math.abs(values.get(i) - values.get(j));
        //         if (difAbs < result) {
        //             result = difAbs;
        //         }
        //     }
        // }

        return result;
    }

    private void inOrder(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) inOrder(node.left, values);
            values.add(node.val);
            if (node.right != null) inOrder(node.right, values);
        }
    }
}