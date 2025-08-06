import java.util.Scanner;

public class SingleNumber {
    
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR each number
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter space-separated integers (duplicates except one):");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int result = singleNumber(nums);
        System.out.println("Single number: " + result);
    }
}
