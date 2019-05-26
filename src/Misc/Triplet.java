package Misc;

import java.util.Arrays;

public class Triplet {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        Arrays.sort(arr);
        for (int i=0; i<n-1; i++) {
            int l = i+1;
            int r = n-1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    System.out.println(x + " " + arr[l] + " " + arr[r]);
                    l++;
                    r--;
                } else if (x + arr[l] + arr[r] < 0)
                    l++;
                else
                    r--;
            }
        }
    }
}
