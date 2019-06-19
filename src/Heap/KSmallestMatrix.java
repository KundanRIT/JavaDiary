package Heap;

import java.util.PriorityQueue;

public class KSmallestMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,  5,  8,  11},
                {6,  7,  9,  12},
                {9,  14, 15, 17},
                {10, 14, 16, 17}
        };

        int n = matrix[0].length;

        int k = 16;
        PriorityQueue<Entry> minheap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minheap.add(new Entry(0, i, matrix[0][i]));
        }

        Entry entry = null;
        for (int i = 0; i < k; i++) {
            entry = minheap.poll();
            if (entry.row < n-1) {
                minheap.add(new Entry(entry.row + 1, entry.column, matrix[entry.row + 1][entry.column]));
            } else {
                minheap.add(new Entry(-1, -1, Integer.MAX_VALUE));
            }
        }

        System.out.println(entry.value);
    }

    static class Entry implements Comparable<Entry> {
        int row, column, value;

        public Entry(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return this.value - o.value;
        }
    }
}
