package Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10};
        int target = 10;
        List<List<Integer>> powerset = new ArrayList<>();
        for (int x: arr) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> f: powerset) {
                List<Integer> s = new ArrayList<>(f);
                temp.add(s);
            }
            for (List<Integer> aTemp : temp) {
                aTemp.add(x);
            }
            temp.add(new ArrayList<>(Collections.singletonList(x)));
            powerset.addAll(temp);
        }
        for (List<Integer> v: powerset) {
            if (target == v.stream().mapToInt(Integer::intValue).sum()) {
                System.out.println(v);
            }
        }
    }
}
