import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FindThePeak finder = new FindThePeak();

        System.out.print("Enter array elements (comma-separated): ");
        String[] tokens = scanner.nextLine().split(",");
        int[] nums = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

        int peakIndex = finder.findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}
