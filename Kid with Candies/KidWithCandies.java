import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;

        // Step 1: Find the maximum number of candies any kid currently has
        for (int candy : candies){
            if (candy > maxCandies){
                maxCandies = candy;
            }
        }

        // Step 2: For each kid, check if giving them all extraCandies
        // makes their total >= maxCandies
        for (int candy : candies){
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }
    // Driver code for testing
    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println(sol.kidsWithCandies(new int[]{2,3,4,1,3}, 3));
        System.out.println(sol.kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        System.out.println(sol.kidsWithCandies(new int[]{12,1,12}, 10));
    }
}