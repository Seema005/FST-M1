package Activities;

// Functional interface
interface Addable {
    int add(int num1, int num2);
}

public class Activity12 {
    public static void main(String[] args) {
        // Lambda expression without a body (single expression)
        Addable ad1 = (a, b) -> (a + b);

        // Lambda expression with a body (multiple statements)
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };

        // Test the lambda expressions
        int result1 = ad1.add(5, 3);
        int result2 = ad2.add(7, 2);

        System.out.println("Result using ad1: " + result1);
        System.out.println("Result using ad2: " + result2);
    }
}
