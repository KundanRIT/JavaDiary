package Misc;

public class FrogJump {
    public static void main(String[] args) {
        int j[] = {3,2,1,0,4};
        System.out.println(jump(j));
    }

    private static int jump(int[] jumps) {
        int n = jumps.length;
        int track[] = new int[n];
        for (int i=1; i<n; i++) {
            track[i] = Integer.MAX_VALUE;
            for (int j=0; j<i; j++) {
                if (i <= j + jumps[j] && track[j] != Integer.MAX_VALUE) {
                    track[i] = Math.min(track[i], track[j] + 1);
                }
            }
        }
        return track[n-1] == Integer.MAX_VALUE ? -1 : track[n-1];
    }
}
