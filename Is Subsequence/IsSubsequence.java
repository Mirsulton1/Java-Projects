class Solution{
    public boolean isSubsequence(String s, String t){
        int i = 0, j = 0;

        while(i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++; // move s pointer
            }
            j++; // always move t pointer
        }
        return i == s.length(); // we found all character of s in order
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isSubsequence("abc", "ahbgdc"));
        System.out.println(sol.isSubsequence("axc", "ahbgdc"));
    }
}


// Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
// and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

//import java.util.*;
//
//class SubsequenceChecker {
//    Map<Character, List<Integer>> indexMap = new HashMap<>();
//
//    public SubsequenceChecker(String t){
//        for (int i = 0; i < t.length(); i++){
//            char c = t.charAt(i);
//            indexMap.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
//        }
//    }
//
//    public boolean isSubsequence(String s){
//        int prevIndex = -1;
//
//        for (char c : s.toCharArray()){
//            if (!indexMap.containsKey(c)) return false;
//
//            List<Integer> indices = indexMap.get(c);
//            int pos = binarySearch(indices, prevIndex);
//            if (pos == -1) return false;
//
//            prevIndex = indices.get(pos);
//        }
//        return true;
//    }
//
//    // Binary search to find the smallest index > prevIndex
//    private int binarySearch(List<Integer> list, int prev){
//        int left = 0, right = list.size() - 1;
//        int result = -1;
//
//        while (left <= right){
//            int mid = (left + right) / 2;
//            if (list.get(mid) > prev){
//                result = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        String t = "ahbgdc";
//        SubsequenceChecker checker = new SubsequenceChecker(t);
//
//        System.out.println(checker.isSubsequence("abc")); // true
//        System.out.println(checker.isSubsequence("axc")); // false
//        System.out.println(checker.isSubsequence("agc")); // true
//    }
//}