package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // Open the browser and navigate to the URL
        driver.get("https://www.v1.training-support.net/selenium/input-events");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the text input element
        WebElement textInput = driver.findElement(By.id("keyPressed"));

        // Create an Actions object
        Actions actions = new Actions(driver);

        // Press the key of the first letter of your name in caps
        actions.sendKeys(textInput, Keys.SHIFT, "A").perform();

        // Sleep for a moment to see the result
        Thread.sleep(2000);

        // Press CTRL+a to select all text and CTRL+c to copy
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("c").perform();

        // Sleep for a moment to allow copying to complete
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
