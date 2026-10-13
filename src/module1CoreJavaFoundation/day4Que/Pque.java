package day4Que;
import java.util.PriorityQueue;
import java.util.Queue;
public class Pque {

        public static void main(String[] args) {
            // Create a PriorityQueue
            PriorityQueue<Integer> q = new PriorityQueue<>();

            // Adding elements (out of order to demonstrate priority)
            q.add(4);
            q.add(1);
            q.add(3);
            q.add(2);

            System.out.println("Initial PriorityQueue: " + q);

            // Poll removes the element with the highest priority (lowest value by default)
            System.out.println("Polled element: " + q.poll()); // 1
            System.out.println("Queue after poll: " + q);
        }

}
