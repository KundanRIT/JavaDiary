package Heap;

import java.util.PriorityQueue;

public class KSmallestFraction {
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 5};

        /*
        1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
         */

        for (int i = 1; i < 7; i++) {
            int x[] = new KSmallestFraction().kthSmallestPrimeFraction(A, i);
            System.out.println(x[0] + " / " + x[1]);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;

        PriorityQueue<Entry> pq = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            pq.add(new Entry(A[0], A[i], 0, i));
        }

        Entry entry = null;

        do {
            entry = pq.poll();
            pq.add(new Entry(A[entry.i + 1], A[entry.j], entry.i+1, entry.j));
        } while (--K > 0);

        return new int[] {(int)entry.p, (int)entry.q};
    }

    class Entry implements Comparable<Entry> {
        int p, q;
        int i, j;

        public Entry(int p, int q, int i, int j) {
            this.p = p;
            this.q = q;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Entry o) {
            return this.p * o.q - this.q * o.p;
        }
    }
}
