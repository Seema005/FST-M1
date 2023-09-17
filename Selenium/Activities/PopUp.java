package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;
        import org.openqa.selenium.interactions.Actions;

public class PopUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        // Open the webpage
        driver.get("https://www.v1.training-support.net/selenium/popups");

        // Print the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the Sign in button and hover over it
        WebElement signInButton = driver.findElement(By.id("signin"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).perform();

        // Print the tooltip message
        WebElement tooltip = driver.findElement(By.className("tooltiptext"));
        String tooltipMessage = tooltip.getText();
        System.out.println("Tooltip Message: " + tooltipMessage);

        // Click the button to open the Sign in form
        signInButton.click();

        // Enter the credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");

        // Click login
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        // Print the message after logging in
        WebElement successMessage = driver.findElement(By.id("action-confirmation"));
        String loginSuccessMessage = successMessage.getText();
        System.out.println("Login Success Message: " + loginSuccessMessage);

        // Close the browser
        driver.quit();
    }
}
