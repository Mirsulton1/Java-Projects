import java.util.*;

public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success){
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++){
            int spell = spells[i];
            int low = 0, high = potions.length;

            while (low < high){
                int mid = (low + high) / 2;
                if ((long) spell * potions[mid] >= success){
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            result[i] = potions.length - low;
        }
        return result;
    }
}
