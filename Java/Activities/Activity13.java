package Activities;
import java.util.ArrayList;
        import java.util.Random;
        import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        // Create a Scanner object to accept input
        Scanner scan = new Scanner(System.in);

        // Create an ArrayList to store integer values
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Create a Random object to generate an index
        Random indexGen = new Random();

        System.out.println("Enter integer values (Ctrl+D or non-integer to exit):");

        // Accept integer values from the console until a non-integer is entered
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        // Convert the ArrayList to an array
        Integer[] nums = list.toArray(new Integer[0]);

        // Generate a random index within the bounds of the array
        int randomIndex = indexGen.nextInt(nums.length);

        // Print the generated index and the value at that index
        System.out.println("Generated Index: " + randomIndex);
        System.out.println("Value at Generated Index: " + nums[randomIndex]);

        // Close the Scanner
        scan.close();
    }
}
