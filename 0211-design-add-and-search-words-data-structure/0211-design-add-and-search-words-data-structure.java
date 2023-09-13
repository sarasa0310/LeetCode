class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    // word의 첫글자를 하나씩 잘라서 key로 만들어 저장하는 방식
    public void addWord(String word) {
        addWord(word, root);
    }

    private void addWord(String word, Node node) {
        // word의 길이가 0이 된다면
        if (word.length() == 0) {
            node.isEnd = true; // 해당 단어가 끝임을 표시하고
            return; // 재귀 종료
        }

        // 첫글자
        char c = word.charAt(0);

        // 해당 노드의 children에 단어가 없으면 새로 추가
        if (!node.children.containsKey(c)) {
            node.children.put(c, new Node());
        }

        // 다음 노드
        Node child = node.children.get(c);

        // 단어 하나 잘라서 재귀 호출
        addWord(word.substring(1), child);
    }
    
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node node, int idx) {
        if (node == null) {
            return false;
        }

        if (idx == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(idx);

        if (c == '.') {
            boolean ret = false;
            for (Node child : node.getChildren()) {
                ret |= search(word, child, idx + 1);
                if (ret) {
                    break;
                }
            }
            return ret;
        } else {
            return search(word, node.children.get(c), idx + 1);
        }
    }

}

// Node 구현
class Node {

    public Map<Character, Node> children = new HashMap<>();
    public boolean isEnd;

    public List<Node> getChildren() {
        return new ArrayList<>(children.values());
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */