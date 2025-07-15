import java.util.*;

public class NumberOfRecentCalls {
    Queue<Integer> queue;

    public NumberOfRecentCalls(){
        queue = new LinkedList<>();
    }

    public int ping(int t){
        // Add the current timestamp to the queue
        queue.add(t);

        // Remove all timestamps older than (t - 3000)
        while (queue.peek() < t - 3000){
            queue.poll();
        }

        // The size of the queue is the number of requests in the window
        return queue.size();
    }

    public static void main(String[] args){
        NumberOfRecentCalls rc = new NumberOfRecentCalls();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
