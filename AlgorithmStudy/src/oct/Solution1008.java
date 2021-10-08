package oct;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Solution1008 {

    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("True : " + trie.search("apple"));
        System.out.println("False : " + trie.search("app"));
        System.out.println("[prefix] True : " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("True : " + trie.search("app"));
        System.out.println("True : " + trie.search("apple"));

        trie = new Trie();
        trie.insert("a");
        System.out.println("True : " + trie.search("a"));
        System.out.println("False : " + trie.search("app"));
    }
}

class Node {
    char ch;
    Node[] nodes = new Node[26];
    boolean isEnd = false;
}
/*
*      r
*     / \
*    x   a
*   / \   \
*  p   t   p
*
* */
class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        int index = word.charAt(0) - 'a';
        insertNode(root, word);
        index = 0;
    }

    private void insertNode(Node node, String word) {
        if (word.length() == 0) {
            node.isEnd = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        if (node.nodes[index] == null) {
            Node child = new Node();
            child.ch = word.charAt(0);
            node.nodes[index] = child;
        }
        insertNode(node.nodes[index], word.substring(1));
    }

    public boolean search(String word) { // <-- isEnd? <apple> search(app)
        return matchNode(root, word);
    }

    private boolean matchNode(Node node, String word) {
        if (word.length() == 0) {
            return node.isEnd;
        }

        int index = word.charAt(0) - 'a';
        if (node.nodes[index] != null) {
            return matchNode(node.nodes[index], word.substring(1));
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) { // true
        return prefixNode(root, prefix);
    }

    private boolean prefixNode(Node node, String word) {
        if (word.length() == 0) {
            return true;
        }

        int index = word.charAt(0) - 'a';
        if (node.nodes[index] != null) {
            return prefixNode(node.nodes[index], word.substring(1));
        } else {
            return false;
        }
    }
}