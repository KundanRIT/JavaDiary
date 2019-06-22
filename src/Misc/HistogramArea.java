package Misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HistogramArea {
    public static void main(String[] args) {
        int u[] = new int[5000];
        Arrays.fill(u, 1);
        System.out.println(largestRectangleArea(u));
    }
    public static int largestRectangleArea(int[] heights) {

        if (heights.length == 0)
            return 0;

        Set<Integer> discard = new HashSet<>();
        int area[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (!discard.contains(i)) {
                int min = heights[i];
                for (int j = i; j < heights.length; j++) {
                    if (heights[j] <= min) {
                        discard.add(j);
                        min = heights[j];
                    }
                    int a = min * (j-i+1);
                    if (a >= area[i])
                        area[i] = a;
                }
            }
        }
        int max = area[0];
        for (int i = 1; i < area.length; i++) {
            if (max < area[i])
                max = area[i];
        }

        return max;
    }
}
