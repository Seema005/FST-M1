package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity15 {
    public static void main(String[] args) {
        // Set up the Chrome WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // Open the webpage
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

        // Type in the credentials
        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");

        // Find and click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Print the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.quit();
    }
}
