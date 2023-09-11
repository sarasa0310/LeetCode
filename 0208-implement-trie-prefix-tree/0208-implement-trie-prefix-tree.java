class Trie {

    private Node root; // 루트 노드

    public Trie() {
        root = new Node();
    }

    // insert, search, startsWith 모두 재귀적 방법으로 구현
    
    public void insert(String word) {
        // 재귀 호출
        insertRecursively(root, word);
    }

    // apple -> pple -> ple -> le -> e -> "" 방식으로 삽입
    private void insertRecursively(Node node, String word) {
        // 더 이상 삽입할 단어가 없다면
        if (word.length() == 0) {
            node.isEnd = true; // 해당 노드가 단어의 끝임을 표시하고
            return; // 재귀 종료
        }

        // Node를 찾기 위한 word의 첫 글자 c
        char c = word.charAt(0);

        // children에 해당 노드가 없으면 c를 key로 새로운 노드 추가
        if (!node.children.containsKey(c))  {
            node.children.put(c, new Node());
        }

        // c를 key로 찾은 다음 노드
        Node child = node.children.get(c);

        // 다음 노드와 첫 글자를 자른 word를 넣어 재귀 호출
        insertRecursively(child, word.substring(1));
    }
    
    public boolean search(String word) {
        // 재귀 호출
        return searchRecursively(root, word);
    }

    private boolean searchRecursively(Node node, String word) {
        // 더 이상 탐색할 단어가 없다면 재귀 종료
        if (word.length() == 0) {
            // 해당 노드가 단어의 끝이면 true, 아니면 false 리턴
            return node.isEnd ? true : false;
        }

        // Node를 찾기 위한 word의 첫 글자 c
        char c = word.charAt(0);

        // children에 해당 노드가 없으면 단어가 없으므로 false 리턴
        if (!node.children.containsKey(c)) return false;

        // 해당 글자로 찾은 노드
        Node child = node.children.get(c);

        // 다음 노드와 첫 글자를 자른 word를 넣어 재귀 호출
        return searchRecursively(child, word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        // 재귀 호출
        return starsWithRecursively(root, prefix);
    }

    private boolean starsWithRecursively(Node node, String word) {
        // 더 이상 탐색할 단어가 없다면 재귀 종료
        if (word.length() == 0) {
            return true;
        }

        // Node를 찾기 위한 word의 첫 글자 c
        char c = word.charAt(0);

        // children에 해당 노드가 없으면 단어가 없으므로 false 리턴
        if (!node.children.containsKey(c)) return false;

        // 해당 글자로 찾은 노드
        Node child = node.children.get(c);

        // 다음 노드와 첫 글자를 자른 word를 넣어 재귀 호출
        return starsWithRecursively(child, word.substring(1));
    }

}

// Trie 자료구조의 Node 구현
class Node {

    // 자식 노드들 children(key - 접두사, value - 노드)
    public Map<Character, Node> children;
    public boolean isEnd; // 해당 노드가 단어의 끝임을 표시하기 위한 isEnd 변수

    public Node() {
        children = new HashMap<>();
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */