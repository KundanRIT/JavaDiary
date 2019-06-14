package Trie;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> index = new HashMap<>();
    boolean wordComplete = false;

    public void insert(String word) {
        TrieNode current = this;
        for (Character ch: word.toCharArray()) {
            if (!current.index.containsKey(ch)) {
                current.index.put(ch, new TrieNode());
            }
            current = current.index.get(ch);
        }
        current.wordComplete = true;
    }
}
