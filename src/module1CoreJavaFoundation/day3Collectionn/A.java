package day3Collectionn;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class A {
        public static void main(String[] args) {

            // 1. CREATE / INITIALIZE the Collection
            List<String> fruits = new ArrayList<>();

            // 2. ADD elements (Insert / Create)
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Cherry");
            fruits.add("Apple"); // Lists allow duplicate elements
            System.out.println("Initial List: " + fruits);

            // 3. READ / RETRIEVE elements
            String firstFruit = fruits.get(0);
            System.out.println("Element at index 0: " + firstFruit);

            // 4. UPDATE / MODIFY elements
            fruits.set(1, "Blueberry"); // Replaces "Banana" at index 1 with "Blueberry"
            System.out.println("After Update (index 1 changed): " + fruits);

            // 5. SEARCH & CHECK elements
            boolean hasCherry = fruits.contains("Cherry");
            System.out.println("Does list contain 'Cherry'? " + hasCherry);

            int indexOfApple = fruits.indexOf("Apple");
            System.out.println("First index of 'Apple': " + indexOfApple);

            // 6. CHECK SIZE
            System.out.println("Total elements in list: " + fruits.size());

            // 7. SORTING the collection
            Collections.sort(fruits);
            System.out.println("After Sorting (Alphabetical): " + fruits);

            // 8. DELETE / REMOVE elements
            fruits.remove("Cherry"); // Removes by object value
            fruits.remove(0);        // Removes element at index 0
            System.out.println("After Removal: " + fruits);

            // 9. ITERATING through the collection
            System.out.println("Iterating through remaining items:");
            for (String fruit : fruits) {
                System.out.println(" -> " + fruit);
            }

            // 10. CLEAR the collection
            fruits.clear();
            System.out.println("Is the list empty now? " + fruits.isEmpty());
        }
}
