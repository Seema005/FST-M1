package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        // Open the browser and navigate to the URL
        driver.get("https://v1.training-support.net/selenium/login-form");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the username field and enter "admin"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("admin");

        // Find the password field and enter "password"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        // Find the "Log in" button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Close the browser
        driver.quit();
    }
}
