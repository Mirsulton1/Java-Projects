import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SuccessfulPairs sp = new SuccessfulPairs();

        System.out.print("Enter spells: ");
        int[] spells = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter potions: ");
        int[] potions = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter success value: ");
        long success = sc.nextLong();

        int[] result = sp.successfulPairs(spells, potions, success);
        System.out.println("Successful Pairs: " + Arrays.toString(result));
    }
}