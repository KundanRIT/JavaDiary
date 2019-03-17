package DC;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(Arrays.toString(mergesort(arr)));
    }

    public static int[] mergesort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int left[] = Arrays.copyOfRange(arr, 0, mid);
        int right[] = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergesort(left), mergesort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        int merged[] = new int[left.length + right.length];
        while (leftIndex != left.length && rightIndex != right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merged[mergedIndex++] = left[leftIndex++];
            } else {
                merged[mergedIndex++] = right[rightIndex++];
            }
        }

        for (int i = leftIndex; i < left.length; i++) {
            merged[mergedIndex++] = left[i];
        }

        for (int i = rightIndex; i < right.length; i++) {
            merged[mergedIndex++] = right[i];
        }

        return merged;
    }

}
