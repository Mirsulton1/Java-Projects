class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces, and split the string by spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the array of words
        StringBuilder reversedWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]);
            if (i > 0) reversedWords.append(" ");
        }
    return reversedWords.toString();
}
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));         // "blue is sky the"
        System.out.println(sol.reverseWords("  hello world  "));         // "world hello"
        System.out.println(sol.reverseWords("a good   example"));        // "example good a"
    }
}



