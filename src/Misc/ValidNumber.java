package Misc;

public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("46.e3"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();

        if (s.isEmpty())
            return false;

        char sign = s.charAt(0);
        if (sign == '+' || sign == '-') {
            s = s.substring(1);
        }
        if (s.isEmpty())
            return false;

        int index = 0, dindex=0;
        while (Character.isDigit(s.charAt(index))) {
            index++;
            if (index == s.length())
                break;
        }
        s = s.substring(index);
        if (s.isEmpty())
            return true;

        if (s.charAt(0) == '.') {
            s = s.substring(1);
            if (s.isEmpty()) {
                return index > 0;
            }

            dindex = 0;
            while (Character.isDigit(s.charAt(dindex))) {
                dindex++;
                if (dindex == s.length())
                    break;
            }
            s = s.substring(dindex);
            if (s.isEmpty())
                return true;
        }

        if (s.charAt(0) == 'e' && (index > 0 || dindex > 0)) {
            s = s.substring(1);
            if (s.isEmpty())
                return false;

            sign = s.charAt(0);
            if (sign == '+' || sign == '-') {
                s = s.substring(1);
            }
            if (s.isEmpty())
                return false;

            index = 0;
            while (Character.isDigit(s.charAt(index))) {
                index++;
                if (index == s.length())
                    break;
            }
            s = s.substring(index);

            return s.isEmpty();
        }

        return false;
    }
}