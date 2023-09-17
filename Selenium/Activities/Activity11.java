package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity11 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // Open the webpage
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the checkbox input element
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        // Check if the checkbox is selected and print the result
        boolean isCheckboxSelected = checkbox.isSelected();
        System.out.println("Checkbox is selected: " + isCheckboxSelected);

        // Click the checkbox to select it
        checkbox.click();

        // Check if the checkbox is selected again and print the result
        isCheckboxSelected = checkbox.isSelected();
        System.out.println("Checkbox is selected after click: " + isCheckboxSelected);

        // Close the browser
        driver.quit();
    }
}
