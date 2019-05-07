package Misc;

public class Closest {
    public static void main(String[] args) {
        int a[] = {10,20,30,40,50,60,70,80,90,100};
        int target = 35;
        System.out.println(binsearch(a,target));
    }

    private static int binsearch(int[] a, int target) {
        int l = a.length;
        if (target < a[0])
            return a[0];
        if (target > a[l-1])
            return a[l-1];
        int i=0, j=l-1, mid=0;
        while (i < j) {
            mid = (i+j)/2;
            if (a[mid]==target)
                return a[mid];
            else if (target < a[mid]) {
                if (mid > 0 && target > a[mid-1])
                    return closest(a[mid-1], target, a[mid]);
                j = mid;
            } else {
                if (mid < l-1 && target < a[mid+1])
                    return closest(a[mid], target, a[mid+1]);
                i = mid;
            }
        }
        return a[mid];
    }

    private static int closest(int v1, int target, int v2) {
        if (target-v1 > v2-target)
            return v2;
        else
            return v1;
    }
}
