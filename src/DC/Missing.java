package DC;

public class Missing {
    public static void main(String[] args) {
        int a[] = {3, 4, 5, 8, 9, 13, 17, 18, 21};
        System.out.println(findMissingK(a, 0, a.length-1, 100));
    }

    public static int findMissingK(int a[], int start, int end, int k) {
        int mid = (end - start)/2;
        if (mid == 0) {
            int diff = a[end] - a[start];
            if (diff > k) {
                return a[start] + k;
            } else {
                return a[end] + k - diff + 1;
            }
        } else {
            int diff = (a[start + mid] - a[start]) - mid;
            if (diff < k) {
                return findMissingK(a, start + mid, end, k-diff);
            } else {
                return findMissingK(a, start, end - mid, k);
            }
        }
    }
}
