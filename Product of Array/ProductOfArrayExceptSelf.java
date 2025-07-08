class Solution {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Build left products
        answer[0] = 1;
        for (int i = 1; i < n; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with right products (in reverse)
        int right = 1;
        for (int i = n - 1; i >= 0; i--){
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        // Example 1
        int[] result1 = sol.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(java.util.Arrays.toString(result1));

        // Example 2
        int[] result2 = sol.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(java.util.Arrays.toString(result2));
    }
}