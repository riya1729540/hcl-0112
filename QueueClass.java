package day4Que;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q); //[1, 2, 3, 4]
        System.out.println(q.poll());//1
        System.out.println(q);//[2, 3, 4]

    }
}
