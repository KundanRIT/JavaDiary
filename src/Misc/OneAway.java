package Misc;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(checkAway("", "") ? "One Away" : "Not One Away");
    }

    private static boolean checkAway(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        if (s1.length() == s2.length()) {
            if (diff(s1, s2) == 1) {
                return true;
            }
        }

        if ((s1.length() - s2.length()) == 1)
            return checkAdd(s1, s2);

        if ((s2.length() - s1.length()) == 1)
            return checkAdd(s2, s1);

        return false;
    }

    public static int diff(String s1, String s2) {
        int c = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                c++;
        }
        return c;
    }

    public static boolean checkAdd(String s1, String s2) {
        boolean oneChance = false;
        for (int i=0, j=0; j<s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)){
                if (!oneChance) {
                    j--;
                    oneChance = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
