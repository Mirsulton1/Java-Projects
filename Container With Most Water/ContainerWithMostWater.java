class Solution{
    public int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);

            // Move the shorter line inward to try a taller one
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height)); // Output 49
    }
}