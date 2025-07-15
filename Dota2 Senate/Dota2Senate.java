import java.util.*;

class Solution{
    public String predictPartyVictory(String senate){
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill queues with the indices of Radiant and Dire senators
        for(int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R'){
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate the rounds
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.poll();
            int d = dire.poll();

            // Whoever comes first bans the other
            if (r < d){
                // Radiant senator bans Dire senator and comes back in the next round
                radiant.offer(r + n);
            } else {
                // Dire senator bans Radiant senator and comes back in the next round
                dire.offer(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.predictPartyVictory("RD"));
        System.out.println(sol.predictPartyVictory("RDD"));
    }
}
