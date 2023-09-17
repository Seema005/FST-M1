package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity20 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();


        // Open the webpage
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the button to open a PROMPT alert and click it
        WebElement promptButton = driver.findElement(By.id("prompt"));
        promptButton.click();

        // Switch the focus to the alert
        org.openqa.selenium.Alert alert = driver.switchTo().alert();

        // Get the text in the alert and print it
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        // Type "Awesome!" into the prompt
        alert.sendKeys("Awesome!");

        // Close the alert with OK
        alert.accept();

        // Close the browser
        driver.quit();
    }
}
