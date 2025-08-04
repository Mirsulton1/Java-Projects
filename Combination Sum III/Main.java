import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinations = solution.combinationSum3(k, n);

        System.out.println("Valid combinations:");
        for (List<Integer> combo : combinations){
            System.out.println(combo);
        }
    }
}
