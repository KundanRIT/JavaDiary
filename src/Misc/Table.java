package Misc;

import java.util.Arrays;

public class Table {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Table().solution(-2)));
    }

    public int[] solution(int x) {
        if (x < 0)
            x = -1*x;
        int res[] = new int[x*x];
        int k = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                res[k++] = i*j;
            }
        }

        return res;
    }
}
