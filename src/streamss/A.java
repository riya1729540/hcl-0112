package module1CoreJavaFoundation.day6ExceptionHandling.streamss;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        // List mein kuch sample data add kar lete hain
        ArrayList<Integer> ar = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<String> str = new ArrayList<>(List.of("Apple", "Banana", "Rate", "Ram", "Ant"));



        str.stream()
                .filter(s -> s.startsWith("R")).filter(s->s.endsWith("e"))     // Sirf 'A' se start hone wale words rakhega
                .forEach(System.out::println);      // Method reference se print karwaya


        ar.stream()
                .map(n->n*n)
                .filter(n -> n % 2 == 0)         // Sirf even numbers ko allow karega
                .forEach(n -> System.out.print(n+" ")); // Har ek filtered element ko print karega


    }
}