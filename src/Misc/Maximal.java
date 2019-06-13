package Misc;

public class Maximal {

    public static void main(String[] args) {
        String[][] matrix = {
                {"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(String[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    int cnt = dfs(matrix, i, j, visited, 0, m, n);
                    if (cnt > count) {
                        count = cnt;
                    }
                }
            }
        }
        return count;
    }

    public static int dfs(String matrix[][], int i, int j, boolean visited[][], int count, int m, int n) {

        if (matrix[i][j].equals("1")) {
            visited[i][j] = true;
            count++;

            if (i + 1 < m && !visited[i + 1][j]) {
                count += dfs(matrix, i + 1, j, visited, 0, m, n);
            }

            if (j + 1 < n && !visited[i][j + 1]) {
                count += dfs(matrix, i, j + 1, visited, 0, m, n);
            }

            if (i - 1 >= 0 && !visited[i - 1][j]) {
                count += dfs(matrix, i - 1, j, visited, 0, m, n);
            }

            if (j - 1 >= 0 && !visited[i][j - 1]) {
                count += dfs(matrix, i, j - 1, visited, 0, m, n);
            }
        }
        return count;
    }
}
