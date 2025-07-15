import java.util.*;

class Solution{
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids){
            boolean destroyed = false;

            // While stack is not empty, and collision might happen
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if (stack.peek() < -asteroid){
                    // Top asteroid explodes
                    stack.pop();
                    continue;
                } else  if (stack.peek() == -asteroid){
                    // Both explode
                    stack.pop();
                }
                // Current asteroid destroyed
                destroyed = true;
                break;
            }
            if (!destroyed){
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[][] testCases = {
                {5,10,-5},
                {8,-8},
                {10,2,-5},
                {-2,-1,1,2},
                {1,-2,-2,-2}
        };

        for (int i = 0; i < testCases.length; i++){
            int[] result = sol.asteroidCollision(testCases[i]);
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Output: " + Arrays.toString(result));
            System.out.println();
        }
    }
}
