package HRM;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {

        WebDriver driver;

        @BeforeTest
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            //Create a new instance of the Firefox driver
            driver = new ChromeDriver();
            // Open the URL
            driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
        public void loginToOrangeHRM() {
            // Find and fill the username and password fields using different selectors
            WebElement usernameField = driver.findElement(By.id("txtUsername")); // Using ID
            WebElement passwordField = driver.findElement(By.cssSelector("input#txtPassword")); // Using CSS Selector

            // Enter login credentials
            usernameField.sendKeys("orange");
            passwordField.sendKeys("orangepassword123");

            // Click on the Login button
            driver.findElement(By.id("btnLogin")).click();

            // Verify the homepage has opened
            String expectedTitle = "OrangeHRM"; // The title of the homepage
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Homepage title doesn't match");

        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }


