package Activity;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class Activity3 {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        // Navigate to the login page
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @AfterClass
    public static void tearDown() {
        // Close the browser
        driver.close();
    }

    @Test
    public void testLoginAndConfirmationMessage() {
        // Find the username and password input fields
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Enter the credentials
        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("password");

        // Click the "Log in" button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Read the confirmation message
        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));

        // Assert the confirmation message
        String expectedMessage = "Welcome Back, admin";
        String actualMessage = confirmationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect confirmation message");
    }
}
