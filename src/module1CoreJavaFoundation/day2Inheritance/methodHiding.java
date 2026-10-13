package day2Inheritance;

public class methodHiding {
    public static void main(String[] args) {
        // Case 1: Parent reference pointing to a Child object
        Parent obj = new Child();
        obj.display(); // Output will be: "Static method from Parent"
    }
}
class Parent {
    static void display() {
        System.out.println("Static method from Parent");
    }
}

class Child extends Parent {
    // This "hides" the parent method, it does NOT override it
    static void display() {
        System.out.println("Static method from Child");
    }
}

