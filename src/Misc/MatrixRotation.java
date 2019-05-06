package Misc;

public class MatrixRotation {
    public static void main(String[] args) {
        int n = 9;
        int m[][] = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = ++k;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        for (int i = 0; i < n/2; i++) {
            for (int j=i; j < n-i-1; j++) {
                int x = m[j][n-i-1];
                m[j][n-i-1] = m[i][j];
                m[i][j] = m[n-j-1][i];
                m[n-j-1][i] = m[n-i-1][n-j-1];
                m[n-i-1][n-j-1] = x;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
