package LeetCode;

//208. Implement Trie (Prefix Tree)
//https://leetcode.com/problems/implement-trie-prefix-tree/

public class LC208_Implement_Trie {
    TrieNode root = new TrieNode();

    public LC208_Implement_Trie() {
    }

    public void insert(String word) {
        if (word == null) return;

        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            p.children[index].val = c;
            p = p.children[index];

            if (i == word.length() - 1) {
                p.children[index].isEnd = true;

            }
        }
    }

    public boolean search(String word) {
        TrieNode p = searchNode(word); //find the last element in the trie
        if (p == null) return false;
        return p.isEnd;
    }

    public boolean startWith(String prefix) {
        TrieNode p = searchNode(prefix);
        return p == null;
    }

    private TrieNode searchNode(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index= c - 'a';
            if (p != null && p.children[index].val == c){
                p = p.children[index];
            } else return null;
        }

        return p;
    }
}
