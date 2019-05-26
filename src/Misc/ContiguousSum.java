package Misc;

public class ContiguousSum {
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int current_max = 0, max_so_far = Integer.MIN_VALUE;
        for (int x: a) {
            current_max += x;
            if (current_max > max_so_far)
                max_so_far = current_max;
            if (current_max < 0)
                current_max = 0;
        }
        System.out.println(max_so_far);
    }
}
