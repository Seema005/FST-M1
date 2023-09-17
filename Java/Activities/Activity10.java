package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<Object> hs = new HashSet<Object>();

        // Add 6 objects to the HashSet
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        hs.add("Date");
        hs.add("Fig");
        hs.add("Grapes");

        // Print the size of the HashSet
        int setSize = hs.size();
        System.out.println("Size of the HashSet: " + setSize);

        // Remove an element from the HashSet
        boolean removed = hs.remove("Cherry");
        System.out.println("Is 'Cherry' removed? " + removed);

        // Try to remove an element not present in the HashSet
        removed = hs.remove("Kiwi");
        System.out.println("Is 'Kiwi' removed? " + removed);

        // Check if an item is in the Set
        boolean containsBanana = hs.contains("Banana");
        System.out.println("Does the HashSet contain 'Banana'? " + containsBanana);

        // Print the updated set
        System.out.println("Updated HashSet: " + hs);
    }
}
