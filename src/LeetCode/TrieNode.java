package LeetCode;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    char val;


    public TrieNode() {
    }

    public TrieNode(char c) {
        val = c;
    }
}
