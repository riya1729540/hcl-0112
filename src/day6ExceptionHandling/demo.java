package module1CoreJavaFoundation.day6ExceptionHandling;

public class demo {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;

            // Division se pehle condition check karein aur custom exception THROW karein
            if (b == 0) {
                throw new CustomDivideByZeroException("Custom Error: 0 se divide karna allowed nahi hai!");
            }

            // Agar exception throw nahi hua toh division normal chalega
            int result = a / b;
            System.out.println("Result: " + result);

        } catch (CustomDivideByZeroException e) {
            // Hamara custom exception yahan CATCH hoga
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block.");
        }

        System.out.println("Program runs successfully...");

    }
}

class CustomDivideByZeroException extends Exception {
    public CustomDivideByZeroException(String message) {
        // Parent Exception class constructor ko message pass kar rahe hain
        super(message);
    }
}


