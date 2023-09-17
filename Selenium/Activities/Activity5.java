package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        // Open the browser and navigate to the URL
        driver.get("https://www.v1.training-support.net/selenium/input-events");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the cube element
        WebElement cube = driver.findElement(By.id("cube"));

        // Perform left click and print the value of the side in the front
        cube.click();
        WebElement frontSide = driver.findElement(By.id("front"));
        System.out.println("Front Side Value (Left Click): " + frontSide.getText());

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Perform double click to show a random side and print the number
        actions.doubleClick(cube).perform();
        WebElement randomSide = driver.findElement(By.id("random"));
        System.out.println("Random Side Number (Double Click): " + randomSide.getText());

        // Perform right click and print the value shown on the front of the cube
        actions.contextClick(cube).perform();
        System.out.println("Front Side Value (Right Click): " + frontSide.getText());

        // Close the browser
        driver.quit();
    }
}
