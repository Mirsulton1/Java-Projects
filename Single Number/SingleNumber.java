import java.util.Scanner;
import java.util.Arrays;

public class SingleNumber {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int[] result = countBits(n);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
