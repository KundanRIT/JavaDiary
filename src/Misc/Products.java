package Misc;

public class Products {
    public static void main(String[] args) {
        int target = 18;
        int count = 0;
        for (int i=1; i*i < target; i++) {
            if (target%i==0)
                count++;
        }
        System.out.println(count);
    }
}
