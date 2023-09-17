package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOff;
    private Date lastTimeLanded;

    // Constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // Method to onboard passengers
    public void onboard(String passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
        } else {
            System.out.println("The plane is already full.");
        }
    }

    // Method to simulate take-off
    public Date takeOff() {
        lastTimeTookOff = new Date();
        return lastTimeTookOff;
    }

    // Method to simulate landing
    public void land() {
        lastTimeLanded = new Date();
        passengers.clear();
    }

    // Method to get the last landing time
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    // Method to get the list of passengers
    public List<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Create a Plane object with a maximum capacity of 10 passengers
        Plane plane = new Plane(10);

        // Onboard passengers
        plane.onboard("Passenger 1");
        plane.onboard("Passenger 2");
        plane.onboard("Passenger 3");

        // Print take-off time
        Date takeOffTime = plane.takeOff();
        System.out.println("Take-off time: " + takeOffTime);

        // Print the list of passengers
        List<String> passengers = plane.getPassengers();
        System.out.println("Passengers onboard: " + passengers);

        // Simulate flight (pause for 5 seconds)
        Thread.sleep(5000);

        // Land the plane
        plane.land();
        Date landingTime = plane.getLastTimeLanded();
        System.out.println("Landing time: " + landingTime);
    }
}

