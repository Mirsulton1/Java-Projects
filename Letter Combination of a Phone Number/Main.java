import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LetterCombinations lc = new LetterCombinations();

        System.out.print("Enter digits (2-9): ");
        String input = sc.nextLine();

        List<String> combinations = lc.letterCombinations(input);

        System.out.print("Possible letter combinations: ");
        for (String combo : combinations){
            System.out.print("\"" + combo + "\" ");
        }
    }
}