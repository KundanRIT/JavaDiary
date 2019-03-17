/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all
 * elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-subsequence
 *
 * More Examples:
 *
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 *
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 *
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 */

package DP;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int seq[] = new int[arr.length];
        Arrays.fill(seq, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    seq[i] = Math.max(seq[i], seq[j] + 1);
                }
            }
        }
        int counter = 1;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == counter) {
                System.out.print(arr[i] + " ");
                counter++;
            }
        }
        System.out.println("\nSize = " + (counter-1));
    }
}
