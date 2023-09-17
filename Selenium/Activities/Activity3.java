package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        // Open the browser and navigate to the URL
        driver.get("https://v1.training-support.net/selenium/login-form");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the username field and enter "admin" using XPath
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("admin");

        // Find the password field and enter "password" using XPath
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("password");

        // Find the "Log in" button and click it using XPath
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Close the browser
        driver.quit();
    }
}
