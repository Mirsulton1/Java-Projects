import java.util.*;

public class DecodeString {
    public String decodeString(String s){
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                k = k * 10 + (ch - '0'); // Handle multi-digit numbers
            } else if (ch == '['){
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']'){
                int count = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i =0; i < count; i++){
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch); // Append normal characters
            }
        }
        return current.toString();
    }

    public static void main(String[] args){
        DecodeString sol = new DecodeString();

        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(sol.decodeString(s1));
        System.out.println(sol.decodeString(s2));
        System.out.println(sol.decodeString(s3));
    }
}
