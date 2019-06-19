package DC;

import java.util.Arrays;

public class Missing2 {
    public static void main(String[] args) {
        int a[] = {-1};
        System.out.println(missing(a));
    }

    private static int missing(int a[]) {

        int n = a.length;

        for (int i=0; i<n; i++) {
            if (a[i] >= 1 && a[i] <= n && a[a[i]-1] != a[i]) {
                int temp = a[a[i]-1];
                a[a[i]-1] = a[i];
                a[i] = temp;
                i--;
            }
        }

        System.out.println(Arrays.toString(a));

        int k = 1;
        while (k <= n) {
            if (a[k-1] != k)
                break;
            k++;
        }

        return k;
    }
}
