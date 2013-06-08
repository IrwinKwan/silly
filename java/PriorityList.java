import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.*;

public class PriorityList {
    public PriorityList() {
    }

    /**
     * Given a structure of N email threads, maintain a list of the most
     * recent four threads. */
    public static void main(String[] args) {

        HashMap<Integer, Integer> threads = new HashMap<Integer, Integer>();
        LinkedList<Integer> priority = new LinkedList<Integer>();

        Random r = new Random(); // Pick a thread at random for simulation purposes
        int emails = 1000;
        int max_threads = 5; // assume that we will get messages for one of 100 threads
        int run = 1;

        while (run <= emails) {
            Integer incoming_thread = new Integer(r.nextInt(max_threads + 1)); // since Random is not inclusive


            if (threads.containsKey(incoming_thread)) {
                threads.put(incoming_thread, threads.get(incoming_thread) + 1);
            } else {
                threads.put(incoming_thread, 1);
            }

            if (priority.contains(incoming_thread)) {
                priority.remove(incoming_thread);
            } else {
                if (priority.size() == 4) {
                    priority.removeLast();
                }
            }
            priority.addFirst(incoming_thread);

            System.out.println("inc: " + incoming_thread);
            System.out.println("priority list: " + Arrays.toString(priority.toArray()));

            run++;
        }


    }
}
