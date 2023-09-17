package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        WebElement ball = driver.findElement(By.id("draggable"));

        // Find the drop zones
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Simulate a click and drag to move the ball into Dropzone 1
        actions.dragAndDrop(ball, dropZone1).build().perform();
        // Verify that the ball has entered Dropzone 1
        String dropZone1Text = dropZone1.getText();
        if (dropZone1Text.equals("Dropped!")) {
            System.out.println("Ball entered Dropzone 1");
        }
        // Find Dropzone 2
        WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

        // Move the ball into Dropzone 2
        actions.dragAndDrop(ball, dropZone2).build().perform();

        // Verify that the ball has entered Dropzone 2
        String dropZone2Text = dropZone2.getText();
        if (dropZone2Text.equals("Dropped!")) {
            System.out.println("Ball entered Dropzone 2");
        }

        // Close the browser
        driver.close();
    }

    }
