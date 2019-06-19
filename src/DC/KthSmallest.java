package DC;

public class KthSmallest {
    public static void main(String[] args) {
        int a[] = {3,5,9,11,13,17,21,26};
        int b[] = {1,4,5,7,14,15,16,17,28};

        System.out.println(kTh(a, 0, b, 0, 8));
    }

    public static int kTh(int a[], int starta, int b[], int startb, int k) {

        System.out.println(starta + " " + startb + " " + k);

        if (starta >= a.length)
            return b[k + startb - 1];

        if (startb >= b.length)
            return a[k + starta - 1];

        if (k == 1) {
            return Math.min(a[starta], b[startb]);
        }

        int index1 = starta + k/2 - 1;
        int index2 = startb + k/2 - 1;
        int key1 = index1 < a.length ? a[index1] : Integer.MAX_VALUE;
        int key2 = index2 < b.length ? b[index2] : Integer.MAX_VALUE;
        if (key1 < key2) {
            return kTh(a, index1+1, b, startb, k - k/2);
        } else {
            return kTh(a, starta, b, index2+1, k - k/2);
        }
    }
}
