package day2constructor;

public class default_constructor {

    String color;
    int wheels;
    //THIS IS A NO ARGS CONSTRUCTOR
    default_constructor() {
        color = "Red";
        wheels = 4;
    }



    public static void main(String[] args) {

        default_constructor obj = new default_constructor();

        System.out.println(obj.color);
        System.out.println(obj.wheels);
    }
}