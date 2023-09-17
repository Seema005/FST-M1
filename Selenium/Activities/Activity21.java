package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;

        import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // Open the webpage
        driver.get("https://www.v1.training-support.net/selenium/tab-opener");

        // Get the title of the main page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: " + pageTitle);

        // Find the button to open a new tab and click it
        WebElement openTabButton = driver.findElement(By.id("opentab"));
        openTabButton.click();

        // Wait for the new tab to open
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // Print all the handles
        System.out.println("All Window Handles: " + windowHandles);

        // Print the title and heading of the new tab
        System.out.println("New Tab Title: " + driver.getTitle());
        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println("New Tab Heading: " + heading.getText());

        // Close the current tab
        driver.close();

        // Switch back to the main tab
        windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // Click the button in the main tab to open another new tab
        openTabButton.click();

        // Wait for the new tab to open
        windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // Print all the handles
        System.out.println("All Window Handles: " + windowHandles);

        // Print the title and heading of the new tab
        System.out.println("New Tab Title: " + driver.getTitle());
        heading = driver.findElement(By.tagName("h1"));
        System.out.println("New Tab Heading: " + heading.getText());

        // Close the browser
        driver.quit();
    }
}
