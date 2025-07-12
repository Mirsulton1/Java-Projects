import java.util.*;
class Solution{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        // Use HashSet to remove duplicates and for fast lookup
        /// These sets will automatically store only unique elements
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Fill the sets with numbers from each array
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Find elements only in nums1
        Set<Integer> onlyNums1 = new HashSet<>(set1);
        // Deletes anything from onlynums1 that also exists in set2
        onlyNums1.removeAll(set2);

        // Find elements only in set2
        Set<Integer> onlyNums2 = new HashSet<>(set2);
        // Deletes anything from onlnums2 that also exists in set1
        onlyNums2.removeAll(set1);

        // Convert sets to lists
        List<Integer> list1 = new ArrayList<>(onlyNums1);
        List<Integer> list2 = new ArrayList<>(onlyNums2);

        return Arrays.asList(list1, list2);
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println("Output: " + sol.findDifference(nums1, nums2));

        int[] nums3 = {1,2,3,3};
        int[] nums4 = {1,1,2,2};
        System.out.println("Output: " + sol.findDifference(nums3, nums4));
    }
}
