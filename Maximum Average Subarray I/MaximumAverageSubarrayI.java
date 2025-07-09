class Solution{
    // Takes a list of numbers [nums] and an integer k
    public double findMaxAverage(int[] nums, int k){
        // Step 1: Compute sum of first window
        double sum = 0;
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }
        // Saves sum as the biggest sum we've seen so far
        double maxSum = sum;

        // Step 2: Slide the window
        // Starts new loop from index k to the end of the array
        for (int i = k; i < nums.length; i++){
            sum = sum - nums[i - k] + nums[i]; // remove left, add right
            // If new sum is bigger than previous best, updates it.
            maxSum = Math.max(maxSum, sum);
        }

        // Step 3: Return average
        return maxSum / k;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)); // 12.75
        System.out.println(sol.findMaxAverage(new int[]{5}, 1));
    }
}
