package suiteExample;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class Activity6 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        // Find the username and password text boxes and the login button
        WebElement usernameTextBox = driver.findElement(By.id("username"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Enter the username and password
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);

        // Click the login button
        loginButton.click();
    }
}
