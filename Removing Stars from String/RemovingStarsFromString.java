class Solution{
    public String removeStars(String s){
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()){
            if (c == '*'){
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        String s1 = "leet**cod*e";
        System.out.println("Output: " + sol.removeStars(s1));

        String s2 = "erase*****";
        System.out.println("Output: " + sol.removeStars(s2));
    }
}
