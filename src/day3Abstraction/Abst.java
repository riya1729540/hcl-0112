package day3Abstraction;

abstract class Abst {
    // First method takes no arguments
    void m1() {
        System.out.println("No args");
    }

    // Overloaded method takes an int parameter (changes the return type or parameter list)
    void m1(int a) {
        System.out.println("With int: " + a);
    }
}

class B extends Abst {
    // If you want to override the first method:
   // @Override
    void m1() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        // Creating an object of class B using the abstract class reference
        Abst obj = new B();

        obj.m1();   // Calls the overridden method in class B -> Prints: hello
        obj.m1(42); // Calls the inherited/overloaded method in class Abst -> Prints: With int from Abst: 42
    }
}