package cdpoo.TD4.exo3;

import java.util.PriorityQueue;
import java.util.Queue;


public class PriorityQueueList {
    public static void main(String[] args) {
        Queue<Integer> entiers = new PriorityQueue<Integer>();
        for (int i = 0; i < 100; i++) {
            entiers.add((int) (Math.random() * 1000));
        }
        System.out.println(entiers);
        
        while (!entiers.isEmpty()) {
            System.out.println(entiers.poll());
        }
    }
}
