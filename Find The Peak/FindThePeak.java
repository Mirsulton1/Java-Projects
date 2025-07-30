public class FindThePeak {
    public int findPeakElement(int[] nums){
        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]){
                // Peak is in the left part (including mid)
                right = mid;
            } else {
                // Peak is in the right part
                left = mid + 1;
            }
        }
        return left;  // or right; they are equal
    }
}
