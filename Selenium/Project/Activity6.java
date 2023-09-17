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

public class Activity6 {

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
        public void verifyDirectoryMenuItem() {
            // Login with credentials
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();

            // Locate the navigation menu
            WebElement directoryMenuItem = driver.findElement(By.cssSelector("a#menu_directory_viewDirectory"));

            // Verify that "Directory" menu item is visible
            Assert.assertTrue(directoryMenuItem.isDisplayed(), "Directory menu item is not visible");

            // Verify that "Directory" menu item is clickable
            Assert.assertTrue(directoryMenuItem.isEnabled(), "Directory menu item is not clickable");

            // Click on the "Directory" menu item
            directoryMenuItem.click();

            // Verify that the heading of the page matches "Search Directory"
            String expectedHeading = "Search Directory";
            String actualHeading = driver.findElement(By.cssSelector("div#content h1")).getText();
            Assert.assertEquals(actualHeading, expectedHeading, "Heading of the page doesn't match");

        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }

}
