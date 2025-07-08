import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        // Creates a HashSet of all vowels
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );

        // Converts the string into a character array so we can modify individual characters
        char[] chars = s.toCharArray();

        // left starts from the beginning of the array
        // right starts from the end
        int left = 0, right = chars.length - 1;

        // Loop continues until both pointers meet or cross
        while (left < right) {
            // Move the left pointer forward until it finds a vowel
            // If it's not a vowel, just skip it
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Move the right pointer backward until it finds a vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

public static void main(String[] args){
    Solution sol = new Solution();
    System.out.println(sol.reverseVowels("IceCreAm"));
    System.out.println(sol.reverseVowels("leetcode"));
    }
}
