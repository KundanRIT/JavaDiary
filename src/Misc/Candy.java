package Misc;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int n = 40; // candy
        int k = 2; // people
        int dist[] = new int[k];

        int c = 0;
        int remaining = n;
        int round = k*(k+1)/2;
        while (remaining >= round) {
            remaining = remaining - round;
            c++;
            round += k*k;
        }

        for (int i=0; i<k; i++) {
            int f = c*k + i + 1;
            if (remaining < f) {
                dist[i] = remaining;
                break;
            }
            remaining = remaining - f;
            dist[i] = f;
        }

        for (int i=0; i<k; i++) {
            dist[i] += c*(c-1)*k/2 + (c)*(i+1);
        }

        System.out.println(Arrays.toString(dist));
    }
}
