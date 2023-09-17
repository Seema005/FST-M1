package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity12 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // Open the webpage
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the text field
        WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));

        // Check if the text field is enabled and print the result
        boolean isTextFieldEnabled = textField.isEnabled();
        System.out.println("Text Field is enabled: " + isTextFieldEnabled);

        // Click the "Enable Input" button to enable the input field
        WebElement enableButton = driver.findElement(By.id("toggleInput"));
        enableButton.click();

        // Check if the text field is enabled again and print the result
        isTextFieldEnabled = textField.isEnabled();
        System.out.println("Text Field is enabled after click: " + isTextFieldEnabled);

        // Close the browser
        driver.quit();
    }
}

