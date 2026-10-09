package day2constructor;

public class usingThisAndSuper {
    public static void main(String[] args) {
        Car c = new Car("Sedan");
    }
}

class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor called");
    }
}

class Car extends Vehicle {
    Car() {
        // This calls the parent constructor first (super)
        super();
        System.out.println("Default Car constructor");
    }

    Car(String type) {
        // This calls the other constructor within the SAME class (this)
        this();
        System.out.println("Parameterized Car constructor: " + type);
    }
}

// First, Vehicle() runs and prints: Vehicle constructor called
//
//Next, the rest of the default Car() runs and prints: Default Car constructor
//
//Finally, Java jumps back to where you started and finishes the parameterized constructor, printing: Parameterized Car constructor: Sedan