class Solution{
    public boolean increasingTriplet(int[] nums){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums){
            if (num <= first){
                first = num; // update the smallest so far
            } else if(num <= second){
                second = num; // update the second smallest so far
            } else {
                // If we find a number create than both -> triplet exists
                return true;
            }
        }
        return false; // no increasing triplet found
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println(sol.increasingTriplet(new int[]{1,2,3,4,5})); // true
        System.out.println(sol.increasingTriplet(new int[]{5,4,3,2,1})); // false
        System.out.println(sol.increasingTriplet(new int[]{2,1,5,0,4,6})); // true
    }
}