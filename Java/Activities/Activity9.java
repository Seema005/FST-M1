package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        // Create an ArrayList of type String
        ArrayList<String> myList = new ArrayList<String>();

        // Add 5 names to the ArrayList
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Eve");

        // Print all the names using a for loop
        System.out.println("Names in the ArrayList:");
        for (String name : myList) {
            System.out.println(name);
        }

        // Retrieve the 3rd name in the ArrayList (index 2)
        String thirdName = myList.get(2);
        System.out.println("\nThird name in the ArrayList: " + thirdName);

        // Check if a name exists in the ArrayList
        String searchName = "Charlie";
        boolean nameExists = myList.contains(searchName);
        System.out.println("\nDoes the ArrayList contain '" + searchName + "': " + nameExists);

        // Print the number of names in the ArrayList
        int listSize = myList.size();
        System.out.println("\nNumber of names in the ArrayList: " + listSize);

        // Remove a name from the list (e.g., "Bob")
        String nameToRemove = "Bob";
        myList.remove(nameToRemove);
        System.out.println("\nName '" + nameToRemove + "' removed from the ArrayList.");

        // Print the size of the list again after removal
        listSize = myList.size();
        System.out.println("Number of names in the ArrayList after removal: " + listSize);
    }
}
