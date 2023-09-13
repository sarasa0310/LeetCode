class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    // word의 첫글자를 하나씩 잘라서 key로 만들어 저장하는 방식
    public void addWord(String word) {
        addWordRecursively(word, root);
    }

    private void addWordRecursively(String word, Node node) {
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
        addWordRecursively(word.substring(1), child);
    }
    
    // 노드를 타고 들어가면서 word의 길이가 0이 될 때까지 탐색
    // .을 어떻게 처리해야하나?
    public boolean search(String word) {
        return search(root, word, 0);
        // return searchRecursively(word, root);
    }

    private boolean search(Node current, String word, int idx) {
        if (current == null) {
            return false;
        }

        if (idx == word.length()) {
            return current.isEnd;
        }

        char ch = word.charAt(idx);
        if (ch == '.') {
            boolean ret = false;
            for (Node child : current.getChildren()) {
                ret |= search(child, word, idx + 1);
                if (ret) {
                    break;
                }
            }
            return ret;
        } else return search(current.children.get(ch), word, idx + 1);
    }

    // public boolean searchRecursively(String word, Node node) {
    //     if (node == null) return false;

    //     // word의 길이가 0이 된다면 검색 성공 -> true 리턴
    //     if (word.length() == 0) return true;

    //     // 첫글자
    //     char c = word.charAt(0);

    //     // '.' 처리
    //     if (c == '.') {
    //         boolean ret = false;
    //         for (Node child : node.getChildren()) {
    //             ret |= searchRecursively(word.substring(1), child);
    //             if (ret) {
    //                 break;
    //             }
    //         }
    //         return ret;
    //     } else {
    //         // 다음 노드
    //         Node child = node.children.get(c);

    //         // 단어 하나 잘라서 재귀 호출
    //         return searchRecursively(word.substring(1), child);
    //     }        
    // }

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