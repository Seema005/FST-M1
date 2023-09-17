package suiteExample;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Reporter;

public class Activity9 {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Navigate to the page with JavaScript alerts
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void switchToDefaultContent() {
        // Switch focus back to the main page
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase() {
        // Find and click the Simple Alert button
        WebElement simpleAlertButton = driver.findElement(By.id("simple"));
        simpleAlertButton.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the alert text and print it
        String alertText = alert.getText();
        Reporter.log("Simple Alert Text: " + alertText, true);

        // Close the alert
        alert.accept();

        // Assert that the alert text is as expected
        Assert.assertEquals(alertText, "This is a JavaScript Alert!");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() {
        // Find and click the Confirm Alert button
        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the alert text and print it
        String alertText = alert.getText();
        Reporter.log("Confirm Alert Text: " + alertText, true);

        // Close the alert by clicking OK
        alert.accept();

        // Assert that the alert text is as expected
        Assert.assertEquals(alertText, "This is a JavaScript Confirmation!");

        // Find and click the Confirm Alert button again
        confirmAlertButton.click();

        // Switch to the alert again
        alert = driver.switchTo().alert();

        // Close the alert by clicking Cancel
        alert.dismiss();
    }

    @Test(priority = 2)
    public void promptAlertTestCase() {
        // Find and click the Prompt Alert button
        WebElement promptAlertButton = driver.findElement(By.id("prompt"));
        promptAlertButton.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Enter text in the alert input box
        alert.sendKeys("Test Input");

        // Get the alert text and print it
        String alertText = alert.getText();
        Reporter.log("Prompt Alert Text: " + alertText, true);

        // Close the alert by clicking OK
        alert.accept();

        // Assert that the alert text is as expected
        Assert.assertEquals(alertText, "This is a JavaScript Prompt!");

        // Find and click the Prompt Alert button again
        promptAlertButton.click();

        // Switch to the alert again
        alert = driver.switchTo().alert();

        // Close the alert by clicking Cancel
        alert.dismiss();
    }
    @AfterClass
    public void tearDown() {
        Reporter.log("Ending Test |");
        //Close the driver
        driver.close();
    }
}

