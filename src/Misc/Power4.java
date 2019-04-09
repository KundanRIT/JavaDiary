package Misc;

public class Power4 {
    public static void main(String[] args) {
        int n = -64;
        String s = Integer.toString(n, 2);
        System.out.println(s);
        if (s.charAt(0) == '-')
            s = s.substring(1);
        if (s.substring(1).replace("0","").isEmpty()) {
            if ((s.length() - s.replace("0", "").length()) % 2 == 0)
                System.out.println(true);
        }
    }
}
