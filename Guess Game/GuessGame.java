import java.util.Scanner;

public class GuessGame{
    private static int pick;  // the number to guess

    // This is the API provided in the problem
    public static int guess(int num){
        if(num == pick) return 0;
        return num > pick ? -1 : 1;
    }

    // The method we implement using binary search
    public static int guessNumber(int n){
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) return mid;
            else if (result < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;  // just in case (should never reach)
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Input the value of n and pick
        System.out.println("Enter n (upper bound): ");
        int n = sc.nextInt();

        System.out.println("Enter the number to pick (1 to n): ");
        pick = sc.nextInt();

        int result = guessNumber(n);
        System.out.println("Guess number is: " + result);
    }
}
