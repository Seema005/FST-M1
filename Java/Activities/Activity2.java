package Activities;

public class Activity2 {
    public static void main(String[] args) {
        // Initialize an array
        int[] numbers = {10, 77, 10, 54, -11, 10};

        // Initialize a variable to store the sum
        int sum = 0;

        // Loop through the array to find and add the 10's
        for (int number : numbers) {
            if (number == 10) {
                sum += number;
            }
        }

        // Check if the sum is equal to 30
        boolean isSumEqual30 = sum == 30;

        // Print the result
        System.out.println("Is the sum of 10's equal to 30? " + isSumEqual30);
    }
}

