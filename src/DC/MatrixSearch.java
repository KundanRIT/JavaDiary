package DC;

public class MatrixSearch {
    public static void main(String[] args) {
        int matrix[][] = {
                {-1},
                {-1},
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n-1;
        int target = -2;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.println("found at "+(i+1)+","+(j+1));
                break;
            } else if (matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }
        System.out.println("not found!");
    }
}
