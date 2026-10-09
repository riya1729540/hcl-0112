package day4Mapp;
import java.util.*;
 public class Student {
    public void main(String[] args) {
        String name;
        int age;
        double marks;5
        int rollno;

        // Constructor
    public Student(String name, int age, double marks, int rollno)
        {
            this.name = name;
            this.age = age;
            this.marks = marks;
            this.rollno = rollno;
        }

        // toString method to print student details cleanly
        @Override
        public String toString() {
            return "Roll No: " + rollno + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
        }
    }

    public class StudentMain {
        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();

            // Adding 10 students to the ArrayList
            students.add(new Student("Alice", 20, 85.5, 101));
            students.add(new Student("Bob", 22, 92.0, 102));
            students.add(new Student("Charlie", 19, 78.5, 103));
            students.add(new Student("David", 21, 88.0, 104));
            students.add(new Student("Eva", 20, 95.5, 105));
            students.add(new Student("Frank", 23, 74.0, 106));
            students.add(new Student("Grace", 18, 91.0, 107));
            students.add(new Student("Hannah", 22, 83.5, 108));
            students.add(new Student("Ian", 19, 89.0, 109));
            students.add(new Student("Jack", 21, 79.5, 110));

            // 1. Print all members originally
            System.out.println("=== Original Student List ===");
            for (Student s : students) {
                System.out.println(s);
            }

            // 2. Sort on the basis of age using Collections.sort() and print
            Collections.sort(students, Comparator.comparingInt(s -> s.age));
            System.out.println("\n=== Sorted by Age (Ascending) ===");
            for (Student s : students) {
                System.out.println(s);
            }

            // 3. Sort on the basis of marks using Collections.sort() and print
            Collections.sort(students, Comparator.comparingDouble(s -> s.marks));
            System.out.println("\n=== Sorted by Marks (Ascending) ===");
            for (Student s : students) {
                System.out.println(s);
            }
        }

}
