import java.util.*;

class Solution{
    public boolean closeStrings(String word1, String word2){
        if (word1.length() != word2.length()) return false;

        // Frequency maps
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) freq1[c - 'a']++;
        for (char c : word2.toCharArray()) freq2[c - 'a']++;

        // Condition 1: Check if both have the same set of unique characters
        for (int i = 0; i < 26; i++){
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq1[i] > 0 && freq2[2] == 0)){
                return false;
            }
        }

        // Condition 2: Check if the frequency distributions are the same
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println(sol.closeStrings("abc", "bca"));
        System.out.println(sol.closeStrings("a", "aa"));
        System.out.println(sol.closeStrings("cabbba", "abbcc"));
    }
}
