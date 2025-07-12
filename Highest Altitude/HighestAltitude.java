class Solution {
    public int largestAltitude(int[] gain){
        int current = 0;  // Start at altitude 0
        int highest = 0;  // Highest altitude so far

        for (int g : gain){
            current += g; // Update current altitude
            highest = Math.max(highest, current); // Update highest if needed
        }

        return highest;
    }

    public static void main (String[] args){
        Solution sol = new Solution();
        int[] gain1 = {-5,1,5,0,-7};
        System.out.println(sol.largestAltitude(gain1));

        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        System.out.println(sol.largestAltitude(gain2));
    }
}
