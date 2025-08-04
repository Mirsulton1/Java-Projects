import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int n, int start, List<Integer> path, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path)); // valid combination found
            return;
        }
        if (k < 0 || n < 0) return; // base case: stop recursion if sum or size exceeded

        for (int i = start; i <= 9; i++) {
            path.add(i); // choose the current number
            backtrack(k - 1, n - i, i + 1, path, result); // move to next number
            path.remove(path.size() - 1); // backtrack: remove last chosen number
        }
    }
}
