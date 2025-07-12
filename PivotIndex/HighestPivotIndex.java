class Solution{
    public int pivotIndex(int[] nums){
        int total = 0;
        for (int num : nums){
            total += num;  // Step 1: Calculate total sum
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++){
            // Step 2: Check if leftSum equals rightSum
            if (leftSum == total - leftSum - nums[i]){
                return i; // Found the pivot index
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums = {1,7,3,6,5,6};
        System.out.println(sol.pivotIndex(nums));

        int[] nums2 = {1,2,3};
        System.out.println(sol.pivotIndex(nums2));

        int[] nums3 = {2,1,-1};
        System.out.println(sol.pivotIndex(nums3));
    }
}
