package Misc;

public class Median {
    public static void main(String[] args) {
        int a[] = {1, 3}; // 1 2 4 6 13 15 17 19
        int b[] = {2, 4};
        System.out.println(median(a, b));
    }

    public static double median(int num1[], int num2[]) {
        int total = num1.length + num2.length;
        if (total % 2 != 0)
            return kTh(num1, 0, num2, 0, total / 2 + 1);
        else
            return (kTh(num1, 0, num2, 0, total / 2) + kTh(num1, 0, num2, 0, total / 2 + 1)) / 2.0;
    }

    public static int kTh(int num1[], int start1, int num2[], int start2, int k) {
        if (start1 >= num1.length)
            return num2[k + start2 - 1];

        if (start2 >= num2.length)
            return num1[k + start1 - 1];

        if (k == 1)
            return Math.min(num1[start1], num2[start2]);

        int index1 = start1 + k / 2 - 1;
        int index2 = start2 + k / 2 - 1;

        int key1 = index1 < num1.length ? num1[index1] : Integer.MAX_VALUE;
        int key2 = index2 < num2.length ? num2[index2] : Integer.MAX_VALUE;

        if (key1 < key2)
            return kTh(num1, start1 + k / 2, num2, start2, k - k / 2);
        else
            return kTh(num1, start1, num2, start2 + k / 2, k - k / 2);
    }
}