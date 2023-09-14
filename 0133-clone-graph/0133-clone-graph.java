/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
- 연결된 무방향 그래프의 노드의 참조가 주어졌을 때
- 그래프의 깊은 복사를 반환
 */

class Solution {
    public Node cloneGraph(Node node) {
        // 주어진 node가 null이면 null 반환
        if (node == null) return null;

        // 너비 우선 탐색(BFS)을 하기 위한 Queue queue
        Queue<Node> queue = new LinkedList<>();
        // 노드를 key와 value로 복제하기 위한 Map map
        Map<Node, Node> map = new HashMap<>();

        // queue와 map에 첫번째 노드를 넣어준다
        queue.add(node);
        map.put(node, new Node(node.val)); // 깊은 복사를 해야하므로 새로운 노드 생성

        // queue가 빌때까지 반복
        while (!queue.isEmpty()) {
            // queue에서 꺼낸 현재 노드
            Node cur = queue.poll();

            // 현재 노드의 인접 노드들 스캔
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) { // 인접 노드가 map에 없으면
                    queue.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                List<Node> neighbors = map.get(cur).neighbors;
                neighbors.add(map.get(neighbor));
            }
        }

        // map에서 node 반환
        return map.get(node);
    }
}