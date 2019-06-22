package DC;

public class MatrixSearch2 {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 3;
        System.out.println(binarysearch(matrix, target));
    }

    public static boolean binarysearch(int matrix[][], int target) {

        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (high < 0) {
            return false;
        }

        int row = high;
        low = 0;
        high = n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
