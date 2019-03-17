package DP;

public class BitonicSubsequence {

    /**
     * Longest Bitonic Subsequence | DP-15
     * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing,
     * then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
     * A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence
     * is considered Bitonic with the increasing part as empty.
     *
     * Examples:
     *
     * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
     * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
     *
     * Input arr[] = {12, 11, 40, 5, 3, 1}
     * Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
     *
     * Input arr[] = {80, 60, 30, 40, 20, 10}
     * Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)
     * Source: Microsoft Interview Question
     */

    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int l = arr.length;

        int lis[][] = new int[arr.length][2];
        int lds[][] = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            lis[i][0] = 1;
            lis[i][1] = -1;
            lds[i][0] = 1;
            lds[i][1] = l;
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lis[j][0] >= lis[i][0]) {
                        lis[i][0] = lis[j][0] + 1;
                        lis[i][1] = j;
                    }
                }
                if (arr[l-j-1] < arr[l-i-1]) {
                    if (lds[l-j-1][0] >= lds[l-i-1][0]) {
                        lds[l-i-1][0] = lds[l-j-1][0] + 1;
                        lds[l-i-1][1] = l-j-1;
                    }
                }
            }
        }

        int maxPivot = 0;
        int pivot = -1;

        for (int i = 0; i < l; i++) {
            if (maxPivot < (lds[i][0] + lis[i][0] - 1)) {
                maxPivot = lds[i][0] + lis[i][0] - 1;
                pivot = i;
            }
        }

        StringBuilder seq = new StringBuilder();
        int index = pivot;
        while (index >= 0) {
            seq.insert(0, arr[index] + " ");
            index = lis[index][1];
        }

        index = lds[pivot][1];
        while (index < l) {
            seq.append(arr[index]).append(" ");
            index = lds[index][1];
        }

        System.out.println(seq);
    }
}
