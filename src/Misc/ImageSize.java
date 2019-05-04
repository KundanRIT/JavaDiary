package Misc;

import java.util.Arrays;

public class ImageSize {
    public static void main(String[] args) {
        int p[][] = {
                {236, 189, 189,   0},
                {236,  80, 189, 189},
                {236,   0, 189,  80},
                {236, 189, 189,  80}
        };
        int newP[][] = scaleImage(p, 4, 4, 6, 6);
        System.out.println(Arrays.deepToString(newP));
    }

    private static int[][] scaleImage(int[][] p, int x1, int y1, int x2, int y2) {
        int scaled[][] = new int[x2][y2];

        double xratio = x1 / (double) x2;
        double yratio = y1 / (double) y2;

        for (int x=0; x<x2; x++) {
            for (int y=0; y<y2; y++) {
                int dy = (int) (y * yratio);
                int dx = (int) (x * xratio);

            }
        }


        return scaled;
    }
}
/**
 * 12 24
 * 36 48
 *
 * 12 18 24
 * 24 30 36
 * 36 42 48
 *
 */
