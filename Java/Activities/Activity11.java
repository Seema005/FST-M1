package Activities;

import java.util.HashMap;
        import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        // Create a Map named "colours" with integer keys and String values
        Map<Integer, String> colours = new HashMap<>();

        // Add 5 random colours to the Map
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Purple");

        // Print the Map to the console
        System.out.println("Colours Map: " + colours);

        // Remove one colour using the remove() method
        colours.remove(4);

        // Check if the colour "Green" exists in the Map using containsValue() method
        boolean containsGreen = colours.containsValue("Green");
        System.out.println("Does the Map contain 'Green'? " + containsGreen);

        // Print the size of the Map using size() method
        int mapSize = colours.size();
        System.out.println("Size of the Map: " + mapSize);
    }
}
