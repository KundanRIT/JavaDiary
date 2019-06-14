package Trie;

import java.util.*;

public class WordSearch {
    public static void main(String[] args) {
//        char board[][] = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String words[] = {"oath", "pea", "eat", "rain"};
        char board[][] = {{'a', 'b'}, {'c', 'd'}};
        String words[] = {"acdb"};
        System.out.println(new WordSearch().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> wordset = new HashSet<>(Arrays.asList(words));
        return new ArrayList<>(findWordsUtil(board, wordset, 0, 0, "", "", board.length, board[0].length, new HashSet<>()));
    }

    public Set<String> findWordsUtil(char[][] board, Set<String> wordset, int i, int j, String word, String revword, int m, int n, Set<String> found) {
        if (i < m && j < n) {

            String current = String.valueOf(board[i][j]);

            String newWord = word + current;
            String newrevword = current + revword;

            if (wordset.contains(newWord))
                found.add(newWord);
            else if (wordset.contains(newrevword))
                found.add(newrevword);

            found = findWordsUtil(board, wordset, i + 1, j, newWord, newrevword, m, n, found);

            found = findWordsUtil(board, wordset, i, j + 1, newWord, newrevword, m, n, found);

            found = findWordsUtil(board, wordset, i + 1, j, current, current, m, n, found);

            found = findWordsUtil(board, wordset, i, j + 1, current, current, m, n, found);

            found = findWordsUtil(board, wordset, i + 1, j, "", "", m, n, found);

            found = findWordsUtil(board, wordset, i, j + 1, "", "", m, n, found);
        }

        return found;
    }
}
