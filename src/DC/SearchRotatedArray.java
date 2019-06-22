package DC;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int A[] = {1,1,1,1,1,0,1};
        System.out.println(search(A, 0));
    }

    public static int search(int[] A, int target) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (A[mid] == target)
                return mid;

            if (A[mid] >= A[low]) { // sorted
                if (target >= A[low] && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // not sorted
                if (target <= A[high] && target > A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

// 2 2 2 5 => 8 5 , 4 10, 20 2,


