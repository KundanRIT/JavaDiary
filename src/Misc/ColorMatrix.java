package Misc;

public class ColorMatrix {
    public static void main(String[] args) {
        int m[][] = {
                {1, 1, 2, 2, 3},
                {1, 1, 2, 2, 3},
                {1, 2, 3, 3, 3},
                {3, 1, 1, 1, 1},
                {3, 1, 1, 1, 1},
        };
        boolean visited[][] = new boolean[5][5];
        int color = -1;
        int count = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                int col = m[i][j];
                if (!visited[i][j]) {
                    int cnt = dfs(m, i, j, visited, col, 0);
                    if (cnt > count) {
                        count = cnt;
                        color = col;
                    }
                }
            }
        }
        System.out.println("Color = "+color+" Count = "+count);
    }

    public static int dfs(int m[][], int i, int j, boolean visited[][], int color, int count) {

        if (m[i][j] == color) {
            visited[i][j] = true;
            count++;

            if (i + 1 < 5 && !visited[i + 1][j]) {
                count += dfs(m, i + 1, j, visited, color, 0);
            }

            if (j + 1 < 5 && !visited[i][j + 1]) {
                count += dfs(m, i, j + 1, visited, color, 0);
            }

            if (i - 1 >= 0 && !visited[i - 1][j]) {
                count += dfs(m, i - 1, j, visited, color, 0);
            }

            if (j - 1 >= 0 && !visited[i][j - 1]) {
                count += dfs(m, i, j - 1, visited, color, 0);
            }
        }
        return count;
    }
}
