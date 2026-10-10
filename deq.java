package day4Que;
import java.util.ArrayDeque;
import java.util.Deque;
public class deq {

        public static void main(String[] args) {
            Deque<Integer> q = new ArrayDeque<>(); // You can also use new LinkedList<>()
            q.offer(1);
            q.offer(2);
            q.offer(3);
            q.offer(4);
            System.out.println(q); //[1, 2, 3, 4]
            System.out.println(q.poll());//1
            System.out.println(q);//[2, 3, 4]
        }

}
