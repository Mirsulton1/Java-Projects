class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n){
            int count = 0;
            int len = flowerbed.length;

            for (int i = 0; i < len; i++){
                // Check if current plot is empty
                if (flowerbed[i] == 0){
                    // Check if the previous and next plots are also empty or out of bounds
                    boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                    boolean emptyRight = (i == len - 1) || (flowerbed[i + 1] == 0);

                    if (emptyLeft && emptyRight){
                        flowerbed[i] = 1; // Plant a flower
                        count++;
                        if (count == n){
                            return true; // Enough flowers planted
                        }
                    }
                }
            }
        return count >= n;
    }

// Driver
public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // true
        System.out.println(sol.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // false
    }
}
