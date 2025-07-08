class Solution {
    public void moveZeros(int[] nums){
        int insertPos = 0;

        // Step 1: Move non-zero values forward
        for (int num : nums){
            if (num != 0){
                nums[insertPos++] = num;
            }
        }

        // Step 2: Fill the rest with 0s
        while (insertPos < nums.length){
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums1 = {0,1, 0, 3, 12};
        sol.moveZeros(nums1);
        System.out.println("After moveZeros: ");
        for (int num : nums1){
            System.out.print(num + " ");
        }

        System.out.println();

        int[] nums2 = {0};
        sol.moveZeros(nums2);
        System.out.println("After moveZeros: ");
        for (int num : nums2){
            System.out.print(num + " ");
        }
    }
}