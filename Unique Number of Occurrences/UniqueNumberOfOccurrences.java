import java.util.*;

class Solution{
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count occurrences of each number
        for (int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Track all frequencies in a set
        Set<Integer> freqSet = new HashSet<>();
        for (int freq : freqMap.values()){
            if (!freqSet.add(freq)){
                // If adding fails, duplicate frequency found
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] arr = {1,2,2,1,1,3};
        System.out.println(sol.uniqueOccurrences(arr));

        int[] arr2 = {1,2};
        System.out.println(sol.uniqueOccurrences(arr2));

        int[] arr3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(sol.uniqueOccurrences(arr3));
    }
}
