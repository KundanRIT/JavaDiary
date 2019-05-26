package DP;

public class Knapsack {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 60;
        System.out.println(knapsack(value, weight, W));
    }

    private static int knapsack(int[] value, int[] weight, int W) {
        int n = value.length;
        int K[][] = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i==0 || j==0)
                    K[i][j] = 0;
                else if (j >= weight[i-1]) {
                    K[i][j] = Math.max(K[i-1][j], value[i-1]+K[i-1][j-weight[i-1]]);
                } else {
                    K[i][j] = K[i-1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(K[i][j] + "\t");
            }
            System.out.println();
        }
        return K[n][W];
    }
}
