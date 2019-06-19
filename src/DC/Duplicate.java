package DC;

public class Duplicate {
    public static void main(String[] args) {
//        int nums[] = {2, 1, 4, 4, 5};
//        System.out.println(findDuplicate(nums));
        String s1 = "kaqeniboluz";
        System.out.println(s1.replaceAll("[aeiou]", ""));
    }

    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            System.out.println(tortoise + " " + hare);
            tortoise = nums[tortoise-1];
            hare = nums[nums[hare-1]-1];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1-1];
            ptr2 = nums[ptr2-1];
        }

        return ptr1;
    }
}