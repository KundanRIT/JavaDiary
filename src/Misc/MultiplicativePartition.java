package Misc;

import java.util.ArrayList;
import java.util.List;

/*
24 -> 8 x 3, 12 x 2, 6 x 4, 2 x 2 x 2 x 3, 4 x 2 x 3, 6 x 2 x 2, 1 x 24
 */

public class MultiplicativePartition {

    static int count = 0;

    public static void main(String[] args) {
        partition(2, 1, 36, new ArrayList<>());
        System.out.println(count);
    }

    public static void partition(int start, int product, int n, List<Integer> combination) {
        if (product == n) {
            System.out.println(combination);
            count++;
        } else {
            for (int i=start; i<=n; i++) {

                if (i*product > n) {
                    break;
                }

                if (n % i == 0) {
                    combination.add(i);
                    partition(i, product*i, n, combination);
                    combination.remove(Integer.valueOf(i));
                }
            }
        }
    }
}
