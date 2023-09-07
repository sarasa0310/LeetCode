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
    public List<Double> averageOfLevels(TreeNode root) {

        /**
        이진 트리의 루트 노드가 주어졌을 때
        각 레벨마다 노드 값의 평균을 List에 담아서 반환
         */

        List<Double> result = new ArrayList<>();

        // BFS?
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            result.add(sum / n);
        }

        return result;
    }
}