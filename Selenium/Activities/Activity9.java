package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the browser and navigate to the URL
        driver.get("https://www.v1.training-support.net/selenium/ajax");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find and click the "Change content" button on the page
        WebElement changeContentButton = driver.findElement(By.id("ajax-content"));
        changeContentButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        String helloMessage = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("HELLO! Message: " + helloMessage);

        // Wait for the text to change to contain "I'm late!" and print the new message on the page
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        String lateMessage = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("I'm late! Message: " + lateMessage);

        // Close the browser
        driver.quit();
    }
}
