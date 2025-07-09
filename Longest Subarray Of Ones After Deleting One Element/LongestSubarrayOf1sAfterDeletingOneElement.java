class Solution{
    public int longestSubarray(int[] nums){
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeros++;
            }

            // If we have more than 1 zero, move the left pointer
            while(zeros > 1){
                if (nums[left] == 0){
                    zeros--;
                }
                left++;
            }

            // Update max length (window size minus 1 element deleted)
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println("After deleting one element from the arrays, these are the outputs:");

        int[] nums1 = {1, 1, 0, 1};
        System.out.println("Output: " + sol.longestSubarray(nums1));

        int[] nums2 = {0,1,1,1,0,1,1,0,1};
        System.out.println("Output: " + sol.longestSubarray(nums2));

        int[] nums3 = {1,1,1};
        System.out.println("Output: " + sol.longestSubarray(nums3));

        int[] nums4 = {0,0,0};
        System.out.println("Output: " + sol.longestSubarray(nums4));
    }
}
