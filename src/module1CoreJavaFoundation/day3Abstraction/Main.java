package day3Abstraction;

// Defining an interface with a static method
interface Interf {
    static void showMessage() {
        System.out.println("Hello from the static method of the interface!");
    }
}

// Wrap the main method inside a public class
public class Main {
    public static void main(String[] args) {
        // Calling the interface's static method using the interface name
        Interf.showMessage();
    }
}