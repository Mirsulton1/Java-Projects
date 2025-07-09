class Solution{
    public int longestOnes(int[] nums, int k){

        int left = 0;
        int maxLen = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++){
            // Count zeros in the window
            if (nums[right] == 0){
                zeros++;
            }

            // If we have more than k zeros, shrink from the left
            while (zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }

            // Track max length of valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
