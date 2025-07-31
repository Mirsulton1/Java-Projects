import java.util.*;

public class LetterCombinations{
    private static final String[] KEYPAD = {
            "", "", "abc", "def", "ghi",  // 0-4
            "jkl", "mno", "pqrs", "tuv", "wxyz"  //5-9
    };

    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result){
        if (index == digits.length()){
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }
}
