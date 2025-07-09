class Solution{
    public int maxVowels(String s, int k){
        // max keeps track of the ost vowels, count tracks how many vowels in the current window
        int max = 0, count = 0;

        // Loops through each character in the string
        for (int i = 0; i < s.length(); i++){
            // If new character is a vowel, add to count
            if (isVowel(s.charAt(i))){
                count++;
            }

            // If window is bigger than k, remove the leftmost character
            if(i >= k && isVowel(s.charAt(i - k))){
                count--;
            }

            // Updates the max if the current count is higher
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isVowel(char c){
        // Checks if the character c is inside this string
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxVowels("abciiidef", 3));
        System.out.println(sol.maxVowels("aeiou", 2));
        System.out.println(sol.maxVowels("leetcode", 3));
    }
}
