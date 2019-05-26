package Misc;

public class SecMax {
    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE;
        for (int x: arr) {
            if (x > max) {
                second_max = max;
                max = x;
            }
            if (x > second_max && x != max) {
                second_max = x;
            }
        }
        System.out.println(second_max);
    }
}
