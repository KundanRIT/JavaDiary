package Misc;

import java.util.*;

public class Repeat {
    public static void main(String[] args) {
        System.out.println(checkRepeat("aabb"));
    }

    private static String checkRepeat(String s) {
        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (store.containsKey(ch))
                store.put(ch, store.get(ch) + 1);
            else
                store.put(ch, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (store.get(ch) == 1)
                return String.valueOf(ch);
        }
        return null;
    }
}

/*
aabc -> b
aabb -> null
*/