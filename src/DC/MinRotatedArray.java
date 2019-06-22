package DC;

public class MinRotatedArray {
    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        if (n == 1)
            return nums[0];

        if (nums[low] < nums[high])
            return nums[low];

        while (low < high) {
            int mid = low + (high - low)/2;

            // 4,5,6,7,1,2,3

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                high = mid;
                low++;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}
