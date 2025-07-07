class Solution {
    public int compress(char[] chars){
        int write = 0; // where to write next character
        int i = 0; // read pointer

        // Loop through the array until we’ve processed every character
        while (i < chars.length){
            // currentChar is the current character we're counting
            char currentChar = chars[i];
            // count will track how many times currentChar appears consecutively
            int count = 0;

            // Count consecutive characters
            while (i < chars.length && chars[i] == currentChar){
                i++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // If count > 1, write the count digits
            if (count > 1){
                for (char c : String.valueOf(count).toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] chars1 = {'a','a','b','b','c','c','c'};
        int len1 = sol.compress(chars1);
        System.out.println("Length: " + len1);
        System.out.print("Compressed: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(chars1[i] + " ");
        }
        System.out.println();

        char[] chars2 = {'a'};
        int len2 = sol.compress(chars2);
        System.out.println("Length: " + len2);
        System.out.print("Compressed: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(chars2[i] + " ");
        }
        System.out.println();

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len3 = sol.compress(chars3);
        System.out.println("Length: " + len3);
        System.out.print("Compressed: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(chars3[i] + " ");
        }
        System.out.println();
    }
}