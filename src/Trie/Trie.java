package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trie {
    public static void main(String[] args) {
        char board[][] = {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        String words[] = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};

        System.out.println(new Trie().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode dictionary = new TrieNode();

        for (String word: words) {
            dictionary.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        Set<String> res = new HashSet<>();

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                Set<String> path = new HashSet<>();
                path.add(i+","+j);
                res.addAll(findWordsUtils(board, dictionary, i, j, new HashSet<>(), String.valueOf(board[i][j]), m, n, path));
            }
        }

        return new ArrayList<>(res);
    }

    public Set<String> findWordsUtils(char[][] board, TrieNode dictionary, int i, int j, Set<String> found, String word, int m, int n, Set<String> path) {
        if (dictionary.index.containsKey(board[i][j])) {
            if (word.equals("e"))
                System.out.println();
            TrieNode next = dictionary.index.get(board[i][j]);
            if (next.wordComplete) {
                found.add(word);
            }
            int cursor[][] = {{0,1},{0,-1},{1,0},{-1,0}};
            int ii = i;
            int jj = j;
            for (int x[] : cursor) {
                i = ii + x[0];
                j = jj + x[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !path.contains(i+","+j)) {
                    if (next.index.containsKey(board[i][j])) {
                        path.add(i+","+j);
                        found = findWordsUtils(board, next, i, j, found, word+board[i][j], m, n, path);
                    } else {
                        path.remove(ii+","+jj);
                    }
                }
            }

        }
        return found;
    }
}
/*
* [["b","a","a","b","a","b"],
*  ["a","b","a","a","a","a"],
*  ["a","b","a","a","a","b"],
*  ["a","b","a","b","b","a"],
*  ["a","a","b","b","a","b"],
*  ["a","a","b","b","b","a"],
*  ["a","a","b","a","a","b"]]
*
* baabaababbbbaaaabaaabbababbb
* */