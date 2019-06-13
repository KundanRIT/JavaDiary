package Misc;

public class ZeroReplace {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public static int longestOnes(int[] A, int K) {
        int n = A.length;
        int d = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 1) {
                d++;
                continue;
            }
            int slide = 0;
            for (int j = i; j < n; j++) {
                if (A[j] != 1) {
                    slide++;
                    if (slide > K)
                        break;
                }
                d++;
            }
            if (d > max)
                max = d;
            d = 0;
        }
        if (d > max)
            max = d;
        return max;
    }
}
