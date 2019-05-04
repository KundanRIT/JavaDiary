package DC;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 80, 21, 60, 41, 50}; // => 10 22  9 33
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quicksort(arr, low, partitionIndex-1);
            quicksort(arr, partitionIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        System.out.println(Arrays.toString(arr));
        return i+1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
