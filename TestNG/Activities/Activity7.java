package suiteExample;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity7 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @DataProvider(name = "Authentication")
    public Object[][] credentials() {
        return new Object[][] {
                { "username1", "password1" },
                { "username2", "password2" }
        };
    }

    @Test(dataProvider = "Authentication")
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
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
